#ifndef __ADAPTER_H__
#define __ADAPTER_H__

#include <stdio.h>
#include "adaptee.h"
#include "target.h"

class adapter : public target, private adaptee
{
public:
    adapter();
    ~adapter();

    void request();
};

adapter::adapter()
{
}

adapter::~adapter()
{
}

void adapter::request() {
    this->specificRequest();
}

#endif//;__ADAPTER_H__