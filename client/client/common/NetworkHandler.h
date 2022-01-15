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
	void connectEvent();	// 连接成功
	void disconnectEvent();	// 断开连接
	void timeoutEvent();	// 进行远程TCP连接

	QByteArray intToBytes(int v);
	int bytesToInt(const QByteArray & b);
private:
	QTcpSocket * socket;	
	QTimer * timer;
	QString host;			// 连接IP
	qint16 port;			// 连接端口号
	bool linked = false;	// 是否连接
	QByteArray buffer;		// 数据缓冲
};

