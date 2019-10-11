#include "EntityList.h"

EntityList::EntityList(){
    list = new vector<Entity*>;//(DEFAULT_SIZE);
}

EntityList::~EntityList() {
    if(nullptr != list) {
        for(auto *e : *list) {
            if(nullptr != e)
                delete e;
        }

        delete list;
    }
}

EntityList::EntityList(EntityList &other) {
    for(Entity *e : *other.list) {
        list->push_back(e->clone());
    }
}

Entity *EntityList::clone() {
    EntityList *p = new EntityList(*this);
    return p;
}

void EntityList::add(Entity *e) {
    if(nullptr == e) 
        return;

    list->push_back(e);
}

vector<Entity*> *EntityList::getList() {
    return list;
}