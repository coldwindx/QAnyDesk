#pragma once

#include <QObject>
#include <QTcpSocket>
#include <QTimer>
#include <QByteArray>
#include "../protocol/Protocol.pb.h"

class NetworkHandler : public QObject
{
	Q_OBJECT
public:
	explicit NetworkHandler(const QString & host, qint16 port, QObject * parent = nullptr);
	~NetworkHandler();

	bool isLinked() const;

	void link();
	void clear();
	void send(Protocol::Protocol protocol);
	void recv();
signals:
	void connected();
	void disconnected();
	void closed();
	void received(Protocol::Protocol);
protected:
	void connectEvent();	// ���ӳɹ�
	void disconnectEvent();	// �Ͽ�����
	void timeoutEvent();	// ����Զ��TCP����

	QByteArray intToBytes(int v);
	int bytesToInt(const QByteArray & b);
private:
	QTcpSocket * socket;	
	QTimer * timer;
	QString host;			// ����IP
	qint16 port;			// ���Ӷ˿ں�
	bool linked = false;	// �Ƿ�����
	QByteArray buffer;		// ���ݻ���
};

