#include "MainWindow.h"
#include "ui_MainWindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

	device = DeviceInfo::init("config.ini");			// ����������Ϣ
	setTrayMenu();										// ϵͳ������ʾ
	connectToServer();									// ����Զ�̷�����
	ui->passwordLabel->setText(device->getPassword());
	connect(ui->connectBtn, &QPushButton::clicked, this, &MainWindow::onRequestAuth);
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
	// �յ�����
	connect(network, &NetworkHandler::received, this, &MainWindow::onRecieved);
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
		// <3> ����
	emit send(protocol);
}

void MainWindow::onDisconnected()
{
	ui->stateLamp->setStyleSheet("background-color:rgb(185,54,54);border-radius:15px");
	ui->stateLabel->setText(QSTRING("����ʧ�ܣ���������������"));
}

void MainWindow::onRecieved(Protocol::Protocol protocol)
{
	// ע���������Ϣ
	if ("ScReplyInfo" == protocol.type())
	{
		Protocol::ScReplyInfo replyInfo = protocol.screplyinfo();
		if (replyInfo.success())
		{
			device->setRegisterId(QString::fromStdString(replyInfo.registerid()));
			ui->idLabel->setText(device->getRegisterId());
			ui->connectBtn->setEnabled(true);
			return;
		}
		ui->idLabel->setText("--- --- ---");
		return;
	}
	// ��֤������Ϣ
	if ("CsRequestAuth" == protocol.type())
	{
		Protocol::CsRequestAuth requestAuth = protocol.csrequestauth();
		bool ok = device->getPassword().toStdString() == requestAuth.password();

		Protocol::ScResponseAuth * responseAuth = new Protocol::ScResponseAuth();
		responseAuth->set_sourceid(requestAuth.targetid());
		responseAuth->set_targetid(requestAuth.sourceid());
		responseAuth->set_success(ok);
		if (!ok) responseAuth->set_msg("�������������");

		Protocol::Protocol response;
		response.set_type("ScResponseAuth");
		response.set_allocated_scresponseauth(responseAuth);
		send(response);
		return;
	}
	// ��֤��Ӧ��Ϣ
	if ("ScResponseAuth" == protocol.type())
	{
		Protocol::ScResponseAuth responseAuth = protocol.scresponseauth();
		if (responseAuth.success())
		{
			// ����Ͷ��
			return;
		}
		QString msg = QString::fromStdString(responseAuth.msg());
		qDebug() << msg;
		return;
	}
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

void MainWindow::onRequestAuth()
{
	qDebug() << QSTRING("������֤����");
	QString remoteId = ui->remoteIdEdit->text().remove(QRegExp("\\s"));
	//// �޷������Լ�
	//if (remoteId == ui->idLabel->text().remove(QRegExp("\\s")))
	//{
	//	QMessageBox::critical(this, "����", "�޷������Լ�");
	//	return;
	//}
	// δ���ӵ�������
	if (!network->isLinked())
	{
		QMessageBox::critical(this, "����", "�޷����ӵ�������");
		return;
	}
	// ������֤����
	QString password = device->getPassword();
	Protocol::CsRequestAuth * requestAuth = new Protocol::CsRequestAuth();
	requestAuth->set_sourceid(device->getRegisterId().toStdString());
	requestAuth->set_targetid(remoteId.toStdString());
	requestAuth->set_password(password.toStdString());

	Protocol::Protocol protocol;
	protocol.set_type("CsRequestAuth");
	protocol.set_allocated_csrequestauth(requestAuth);
	// ����
	emit send(protocol);
}


