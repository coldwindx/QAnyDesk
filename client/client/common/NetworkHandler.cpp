#include "NetworkHandler.h"
#include "Global.h"

NetworkHandler::NetworkHandler(const QString & host, qint16 port, QObject * parent) : QObject(parent)
{
	this->host = host;
	this->port = port;
}

NetworkHandler::~NetworkHandler()
{
	qDebug() << QSTRING("NetworkHandler被释放");
}

void NetworkHandler::link()
{
	this->socket = new QTcpSocket(this);
	this->timer = new QTimer();
	// 设置监听
	connect(socket, &QTcpSocket::connected, this, &NetworkHandler::connectEvent);
	connect(socket, &QTcpSocket::disconnected, this, &NetworkHandler::disconnectEvent);
	connect(socket, &QTcpSocket::readyRead, this, &NetworkHandler::recv);
	// 开启连接定时器
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
	qDebug() << QSTRING("发送数据：") << QString::fromStdString(data);
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
		// <1> 处理粘包和拆包
		if (bsize < sizeof(quint32))
			break;
		len = bytesToInt(buffer);
		if (bsize < sizeof(quint32) + len)
			break;
		QByteArray buf = buffer.mid(sizeof(quint32), len);
		// <2> 反序列化
		Protocol::Protocol protocol;
		protocol.ParseFromString(buf.toStdString());
		// <3> 处理协议
		emit received(protocol);
		// <4> 更新数据
		buffer = buffer.right(bsize - sizeof(quint32) - len);
		bsize = buffer.size();
	}
}

void NetworkHandler::connectEvent()
{
	qDebug() << QSTRING("连接到远程服务器！");
	this->isLinked = true;	
	if (timer->isActive()) timer->stop();
	emit connected();
}

void NetworkHandler::disconnectEvent()
{
	qDebug() << QSTRING("连接已断开！");
	this->isLinked = false;
	if(!timer->isActive()) timer->start(5000);
	emit disconnected();
}

void NetworkHandler::timeoutEvent()
{
	if (isLinked) return;
	qDebug() << QSTRING("尝试连接远程服务器！");
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