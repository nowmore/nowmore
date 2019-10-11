#ifndef __ENTITYMAP_H__
#define __ENTITYMAP_H__

#include <unordered_map>
#include "Entity.h"

using std::unordered_map;
using std::string;
class EntityMap : public Entity
{
private:
    unordered_map<string, Entity*> *map;

    EntityMap(EntityMap &other);
public:
    EntityMap(/* args */);
    ~EntityMap();

    Entity *clone();

    void put(string k, Entity * v);
};

#endif//;__ENTITYMAP_H__