#include "MainWindow.h"
#include <QApplication>
#include <QDateTime>
#include <QFileInfo>
#include <QDir>
#include <Windows.h>
#include <QDebug>
#include <google/protobuf/stubs/common.h>


#ifdef Q_OS_WIN
// 单一实例
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
	GOOGLE_PROTOBUF_VERIFY_VERSION;         // 启用protobuf
	QApplication a(argc, argv);
	a.setQuitOnLastWindowClosed(false);     // 主窗口关闭，程序不退出
	MainWindow w;
	w.show();
	int ret = a.exec();
	google::protobuf::ShutdownProtobufLibrary();    // 关闭所有protobuf的lib库
	return ret;
}