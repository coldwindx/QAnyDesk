#pragma once

#include <QObject>
#include <QSettings>
#include <QUuid>
#include "Global.h"

class DeviceInfo : public QObject
{
	Q_OBJECT
public:
	explicit DeviceInfo(QObject * parent = nullptr) : QObject(parent) {}
	~DeviceInfo();
	void setHost(QString host);
	void setPort(quint16 port);
	void setId(QString id);
	QString getHost();
	quint16 getPort();
	QString getId();
	// ��ȡ��������IP
	QString netWorkIp();
	// ��ȡ����MAC��ַ
	QString macAddress();
	// ��ȡӲ��ID
	QString diskDeviceID();
	// ��ȡƽ̨CPU��ID
	QString platformCpuId();
	// ��ȡ����
	QString getPassword();
	// ��������
	void setPassword(const QString & password);
	QString getRemoteHost() const;
	qint16 getRemotePort() const;

	static DeviceInfo * init(QString filename);
	static QString hash(const QString & str1, const QString & str2);
	static void xorData(QByteArray & data);
protected:
	void getcpuid(unsigned int CPUInfo[4], unsigned int InfoType);
	void getcpuidex(unsigned int CPUInfo[4], unsigned int InfoType, unsigned int ECXValue);
private:
	QString host;			
	quint16 port;
	QString password;
	QString id;

	QString remoteHost;
	qint16 remotePort;

};
