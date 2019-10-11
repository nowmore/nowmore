#include <stdio.h>

#include "adapter.h"

int main(int argc, char const *argv[])
{
    target *t = new adapter;
    t->request();
    delete t;
    return 0;
}
