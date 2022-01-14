#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QSystemTrayIcon>
#include <QCommonStyle>
#include <QThread>
#include "common/Global.h"
#include "common/DeviceInfo.h"
#include "common/NetworkHandler.h"

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
protected:
	void setTrayMenu();
	void connectToServer();

	void onConnected();
	void onDisconnected();
	void quit();
private:
    Ui::MainWindow *ui;

	DeviceInfo * device;		// �����豸��Ϣ
	QThread * thread;			// ���ӷ������߳�
	NetworkHandler * network;
};

#endif // MAINWINDOW_H
