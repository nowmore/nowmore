#ifndef __ADAPTEE_H__
#define __ADAPTEE_H__

#include <stdio.h>

class adaptee
{
public:
    adaptee();
    virtual ~adaptee();

    void specificRequest();
};

adaptee::adaptee()
{
}

adaptee::~adaptee()
{
}

void adaptee::specificRequest() {
     printf("Adaptee::SpecificRequest\n");
}


#endif//;__ADAPTEE_H__