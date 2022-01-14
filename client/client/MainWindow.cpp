#include "MainWindow.h"
#include "ui_MainWindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

	device = DeviceInfo::init("config.ini");	// ����������Ϣ
	setTrayMenu();								// ϵͳ������ʾ
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
	// ����ϵͳͼ��
	QCommonStyle style;
	// <1> ��������
	QAction * open = new QAction(QIcon(style.standardPixmap(QStyle::SP_ComputerIcon)), QSTRING("��������"));
	connect(open, &QAction::triggered, this, [&]() { this->show(); });
	menu->addAction(open);
	// <2> �˳�����
	QAction * close = new QAction(QIcon(style.standardPixmap(QStyle::SP_DialogCancelButton)), QSTRING("�˳�"));
	connect(close, &QAction::triggered, this, [&]() { emit closed(); });
	menu->addAction(close);
	// ϵͳ����ͼ��
	tray->setContextMenu(menu);
	tray->setIcon(QIcon(":/img/favicon.ico"));
	tray->setToolTip("QnyDesk");
	tray->show();
}

void MainWindow::connectToServer()
{
	qDebug() << QSTRING("��ʼ�������������ӣ�");
	thread = new QThread();
	network = new NetworkHandler(device->getRemoteHost(), device->getRemotePort());
	// NetworkHandler���ж�ʱ��������ʹ�òۺ�������
	connect(thread, &QThread::started, network, &NetworkHandler::link);
	// ���ӳɹ�
	connect(network, &NetworkHandler::connected, this, &MainWindow::onConnected);
	// ����ʧ��
	connect(network, &NetworkHandler::disconnected, this, &MainWindow::onDisconnected);
	// ���ڹر��¼�
	connect(this, &MainWindow::closed, this, &MainWindow::quit);
	// ��������
	connect(this, &MainWindow::send, network, &NetworkHandler::send);
	network->moveToThread(thread);
	thread->start();
}

void MainWindow::onConnected()
{
	ui->stateLamp->setStyleSheet("background-color:rgb(50,190,166);border-radius:15px");
	ui->stateLabel->setText(QSTRING("����"));
	// ����ע����Ϣ
		// <1> �豸��Ϣ
	Protocol::CsHostInfo * info = new Protocol::CsHostInfo();
	QString hash = DeviceInfo::hash(device->platformCpuId(), device->macAddress());
	info->set_diskdeviceid(device->diskDeviceID().toStdString());
	info->set_cpuid(hash.toStdString());        // ʹ��C++��׼string
	info->set_macaddress(device->macAddress().toStdString());

	Protocol::Protocol protocol;
	protocol.set_type("CsHostInfo");
	protocol.set_allocated_cshostinfo(info);
		// <2> ���л�
	int size = protocol.ByteSize();
	char * buf = new char[size];
	protocol.SerializeToArray(buf, size);
		// <3> ����
	emit send(buf, size);
}

void MainWindow::onDisconnected()
{
	ui->stateLamp->setStyleSheet("background-color:rgb(185,54,54);border-radius:15px");
	ui->stateLabel->setText(QSTRING("����ʧ�ܣ���������������"));
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


