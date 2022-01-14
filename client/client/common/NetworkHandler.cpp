#include "NetworkHandler.h"
#include "Global.h"

NetworkHandler::NetworkHandler(const QString & host, qint16 port, QObject * parent) : QObject(parent)
{
	this->host = host;
	this->port = port;
}

NetworkHandler::~NetworkHandler()
{
	qDebug() << QSTRING("NetworkHandler���ͷ�");
}

void NetworkHandler::link()
{
	this->socket = new QTcpSocket(this);
	this->timer = new QTimer();
	// ���ü���
	connect(socket, &QTcpSocket::connected, this, &NetworkHandler::connectEvent);
	connect(socket, &QTcpSocket::disconnected, this, &NetworkHandler::disconnectEvent);
	connect(socket, &QTcpSocket::readyRead, this, &NetworkHandler::recv);
	// �������Ӷ�ʱ��
	connect(timer, &QTimer::timeout, this, &NetworkHandler::timeoutEvent);
	timer->start(5000);
}

void NetworkHandler::clear()
{
	if (!timer)
	{
		if (timer->isActive())
			timer->stop();
		timer->deleteLater();
	}
	if (!socket)
	{
		if (QAbstractSocket::UnconnectedState != socket->state())
			socket->close();
		socket->disconnectFromHost();
		socket->deleteLater();
	}
	emit closed();
}

void NetworkHandler::send(const char * data, int len)
{
	qDebug() << QSTRING("�������ݣ�") << QString::fromStdString(data);
	socket->write(intToBytes(len), sizeof(quint32));
	int ok = socket->write(data, len);
	socket->flush();
	if (-1 == ok)
		qDebug() << "Fail to send data to server!";
}

void NetworkHandler::recv()
{
	if (socket->bytesAvailable() < 0)
		return;
	QByteArray msg = socket->readAll();
	buffer.append(msg);
	int bsize = buffer.size();
	int len = 0;
	while (bsize)
	{
		// <1> ����ճ���Ͳ��
		if (bsize < sizeof(quint32))
			break;
		len = bytesToInt(buffer);
		if (bsize < sizeof(quint32) + len)
			break;
		QByteArray buf = buffer.mid(sizeof(quint32), len);
		// <2> �����л�
		Protocol::Protocol protocol;
		protocol.ParseFromString(buf.toStdString());
		// <3> ����Э��
		emit received(protocol);
		// <4> ��������
		buffer = buffer.right(bsize - sizeof(quint32) - len);
		bsize = buffer.size();
	}
}

void NetworkHandler::connectEvent()
{
	qDebug() << QSTRING("���ӵ�Զ�̷�������");
	this->isLinked = true;	
	if (timer->isActive()) timer->stop();
	emit connected();
}

void NetworkHandler::disconnectEvent()
{
	qDebug() << QSTRING("�����ѶϿ���");
	this->isLinked = false;
	if(!timer->isActive()) timer->start(5000);
	emit disconnected();
}

void NetworkHandler::timeoutEvent()
{
	if (isLinked) return;
	qDebug() << QSTRING("��������Զ�̷�������");
	socket->abort();
	socket->connectToHost(host, port);
}

QByteArray NetworkHandler::intToBytes(int n)
{
	QByteArray buf;
	buf.resize(4);
	buf[3] = static_cast<quint16>(n & 0xff);
	buf[2] = static_cast<quint16>(n >> 8 & 0xff);
	buf[1] = static_cast<quint16>(n >> 16 & 0xff);
	buf[0] = static_cast<quint16>(n >> 24 & 0xff);
	return buf;
}

int NetworkHandler::bytesToInt(const QByteArray & b)
{
	return b[3] & 0xff | (b[2] & 0xff) << 8 | (b[1] & 0xff) << 16 | (b[0] & 0xff) << 24;
}