#ifndef __ENTITYLIST_H__
#define __ENTITYLIST_H__

#include <vector>
#include "Entity.h"

// #define DEFAULT_SIZE 6
using std::vector;

class EntityList : public Entity
{
private:
    vector<Entity*> *list;
    
    EntityList(EntityList &other);
public:
    EntityList(/* args */);
    ~EntityList();

    Entity *clone();

    void add(Entity *e);

    vector<Entity*> *getList();
};

#endif//;__ENTITYLIST_H__