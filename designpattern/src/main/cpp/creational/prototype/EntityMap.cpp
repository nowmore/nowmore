#include "EntityMap.h"

EntityMap::EntityMap(){
    map = new unordered_map<string, Entity*>;
}

EntityMap::~EntityMap() {
    if(nullptr != map) {
        for(auto it =map->begin(); it != map->end(); ++it) {
            if(nullptr != it->second) 
                delete it->second;
        }

        delete map;
    }
}

EntityMap::EntityMap(EntityMap &other) {
    for(auto it = other.map->begin(); it != other.map->end(); ++it) {
        map->insert({it->first, it->second->clone()});
    }
}

Entity *EntityMap::clone() {
    EntityMap *p = new EntityMap(*this);
    return p;
}

void EntityMap::put(string k, Entity * v) { 
    map->insert({k, v});
}