#include "MainWindow.h"
#include <QApplication>
#include <QDateTime>
#include <QFileInfo>
#include <QDir>
#include <Windows.h>
#include <QDebug>
#include <google/protobuf/stubs/common.h>


#ifdef Q_OS_WIN
// ��һʵ��
bool isAlreadyRun()
{
	HANDLE hMutex = ::CreateMutexA(nullptr, FALSE, "TEST");
	return hMutex && ERROR_ALREADY_EXISTS == ::GetLastError();
}
#endif

int main(int argc, char *argv[])
{
#ifdef Q_OS_WIN
	if (isAlreadyRun()) return 0;
#endif
	GOOGLE_PROTOBUF_VERIFY_VERSION;         // ����protobuf
	QApplication a(argc, argv);
	a.setQuitOnLastWindowClosed(false);     // �����ڹرգ������˳�
	MainWindow w;
	w.show();
	int ret = a.exec();
	google::protobuf::ShutdownProtobufLibrary();    // �ر�����protobuf��lib��
	return ret;
}