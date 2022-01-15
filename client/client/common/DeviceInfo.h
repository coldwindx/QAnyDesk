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
	QString getRegisterId();
	void setRegisterId(const QString & registerId);
	// 获取本机网络IP
	QString netWorkIp();
	// 获取本机MAC地址
	QString macAddress();
	// 获取硬盘ID
	QString diskDeviceID();
	// 获取平台CPU的ID
	QString platformCpuId();
	// 获取密码
	QString getPassword();
	// 设置密码
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
	QString remoteHost;		// 服务器host
	qint16 remotePort;		// 服务器port

	QString registerId;
	QString password;

};
