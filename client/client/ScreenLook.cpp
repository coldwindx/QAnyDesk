#include "ScreenLook.h"

ScreenLook::ScreenLook(DeviceInfo * device, QWidget * parent) : QWidget(parent)
{
	this->device = device;
}

ScreenLook::~ScreenLook()
{
}

void ScreenLook::init(const QString & remoteId, const QString & password)
{
	thread = new QThread();
	network = new NetworkHandler(device->getRemoteHost(), device->getRemotePort());
	connect(thread, &QThread::started, network, &NetworkHandler::link);
	connect(network, &NetworkHandler::connected, this, &ScreenLook::connectEvent);
	network->moveToThread(thread);
	thread->start();
}

void ScreenLook::closeEvent(QCloseEvent * event)
{
	network->clear();
	network->deleteLater();
	thread->quit();
	thread->wait();
	thread->deleteLater();
	event->accept();
}

void ScreenLook::connectEvent()
{
	// 发送认证请求

}


