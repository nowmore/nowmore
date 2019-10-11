#include <stdio.h>

#include "singleton.h"

int main(int argc, char const *argv[])
{
    singleton *o1 = singleton::getInstance();
    singleton *o2 = singleton::getInstance();

    printf("o1's UID = %d, o2's UID = %d\n", 
        o1->getUID(), o2->getUID());

    singleton::release();
    
    return 0;
}
