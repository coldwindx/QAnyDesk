#include "MainWindow.h"
#include "ui_MainWindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

	device = DeviceInfo::init("config.ini");	// 加载配置信息
	setTrayMenu();								// 系统托盘显示
	connectToServer();


}

MainWindow::~MainWindow()
{
	delete device;
    delete ui;
}

void MainWindow::setTrayMenu()
{
	QSystemTrayIcon * tray = new QSystemTrayIcon(this);
	QMenu * menu = new QMenu(this);
	// 加载系统图标
	QCommonStyle style;
	// <1> 打开主界面
	QAction * open = new QAction(QIcon(style.standardPixmap(QStyle::SP_ComputerIcon)), QSTRING("打开主界面"));
	connect(open, &QAction::triggered, this, [&]() { this->show(); });
	menu->addAction(open);
	// <2> 退出程序
	QAction * close = new QAction(QIcon(style.standardPixmap(QStyle::SP_DialogCancelButton)), QSTRING("退出"));
	connect(close, &QAction::triggered, this, [&]() { emit closed(); });
	menu->addAction(close);
	// 系统托盘图标
	tray->setContextMenu(menu);
	tray->setIcon(QIcon(":/img/favicon.ico"));
	tray->setToolTip("QnyDesk");
	tray->show();
}

void MainWindow::connectToServer()
{
	qDebug() << QSTRING("开始建立服务器连接！");
	thread = new QThread();
	network = new NetworkHandler(device->getRemoteHost(), device->getRemotePort());
	// NetworkHandler里有定时器，必须使用槽函数启动
	connect(thread, &QThread::started, network, &NetworkHandler::link);
	// 连接成功
	connect(network, &NetworkHandler::connected, this, &MainWindow::onConnected);
	// 连接失败
	connect(network, &NetworkHandler::disconnected, this, &MainWindow::onDisconnected);
	// 窗口关闭事件
	connect(this, &MainWindow::closed, this, &MainWindow::quit);
	network->moveToThread(thread);
	thread->start();
}

void MainWindow::onConnected()
{
	ui->stateLamp->setStyleSheet("background-color:rgb(50,190,166);border-radius:15px");
	ui->stateLabel->setText(QSTRING("就绪"));
}

void MainWindow::onDisconnected()
{
	ui->stateLamp->setStyleSheet("background-color:rgb(185,54,54);border-radius:15px");
	ui->stateLabel->setText(QSTRING("连接失败，启动重启。。。"));
}

void MainWindow::quit()
{
	network->clear();
	network->deleteLater();
	thread->quit();
	thread->wait();
	thread->deleteLater();
	QApplication::quit();
}


