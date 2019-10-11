#ifndef __ENTITYOBJ_H__
#define __ENTITYOBJ_H__

#include "Entity.h"
#include <iostream>
using std::ostream;
class EntityObj : public Entity
{
friend ostream& operator<<(ostream&,const EntityObj&);
private:
    char *data;

    EntityObj(EntityObj &other);

public:
    EntityObj() = delete;
    EntityObj(const char *data);

    ~EntityObj();

    Entity *clone();
};



#endif//;__ENTITYOBJ_H__