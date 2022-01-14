#pragma once

#include <QObject>
#include <QTcpSocket>
#include <QTimer>
#include <QByteArray>
#include "../protocol/QMessage.pb.h"
#include "../protocol/CsHostInfo.pb.h"

class NetworkHandler : public QObject
{
	Q_OBJECT
public:
	explicit NetworkHandler(const QString & host, qint16 port, QObject * parent = nullptr);
	~NetworkHandler();

	void link();
	void clear();
	void send(const char* data, int len);
signals:
	void connected();
	void disconnected();
	void closed();
protected:
	void connectEvent();	// 连接成功
	void disconnectEvent();	// 断开连接
	void timeoutEvent();	// 进行远程TCP连接

	QByteArray intToBytes(int v);
private:
	QTcpSocket * socket;	
	QTimer * timer;
	QString host;			// 连接IP
	qint16 port;			// 连接端口号
	bool isLinked = false;	// 是否连接
};

