#include <iostream>

#include "Entity.h"
#include "EntityObj.h"
#include "EntityList.h"
//#include "EntityMap.h"
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    EntityObj *o1 = new EntityObj("test1");
    EntityObj *o2 = new EntityObj("test2");
    EntityList *l1 = new EntityList;
    //EntityMap *m1 = new EntityMap;

    l1->add(o1);//l1析构时会delete o1,所以不能在l1析构以后对o1执行操作，如果不想o1被析构，add(o1->clone())
    l1->add(o2->clone());

    for(auto e : *l1->getList()) {
        cout << *(dynamic_cast<EntityObj*>(e)) << endl;
    }

    delete o2;
    delete l1;

    return 0;
}
