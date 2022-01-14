#pragma once
// ดฆภํVSยาย๋
#if _WIN32 
#define QSTRING(str) QString::fromLocal8Bit(str)
#else
#define QSTRING(str) QString(str)
#endif
