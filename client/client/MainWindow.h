#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QSystemTrayIcon>
#include <QCommonStyle>
#include <QThread>
#include "common/Global.h"
#include "common/DeviceInfo.h"
#include "common/NetworkHandler.h"
#include "protocol/Protocol.pb.h"

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = nullptr);
	~MainWindow();
signals:
	void closed();
	void send(const char * data, int len);
protected:
	void setTrayMenu();
	void connectToServer();

	void onConnected();
	void onDisconnected();
	void quit();
private:
    Ui::MainWindow *ui;

	DeviceInfo * device;		// 本机设备信息
	QThread * thread;			// 连接服务器线程
	NetworkHandler * network;
};

#endif // MAINWINDOW_H
