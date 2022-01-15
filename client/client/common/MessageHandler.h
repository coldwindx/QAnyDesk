#pragma once
#include "../protocol/Protocol.pb.h"

class MessageHandler
{
public:
	virtual std::string getType() = 0;
	virtual void execute(Protocol::Protocol protocol) = 0;
};