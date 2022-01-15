#pragma once
#include <QWidget>
#include <QThread>
#include <QCloseEvent>
#include "common/DeviceInfo.h"
#include "common/NetworkHandler.h"

class ScreenLook : public QWidget
{
public:
	explicit ScreenLook(DeviceInfo *deviceInfo, QWidget *parent = nullptr);
	~ScreenLook();
	void init(const QString & remoteId, const QString & password);
protected:
	virtual void closeEvent(QCloseEvent *event);
	void connectEvent();
private:
	DeviceInfo * device;		// 本机信息

	QThread * thread;
	NetworkHandler * network;
};

