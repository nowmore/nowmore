#ifndef __TARGET_H__
#define __TARGET_H__

#include <stdio.h>

class target
{
public:
    target();
    virtual ~target();
    virtual void request();
};

target::target()
{
}

target::~target()
{
}

void target::request() {
    printf("target::request\n");
}

#endif//;__TARGET_H__