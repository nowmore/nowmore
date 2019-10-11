#include "EntityObj.h"

#include <string.h>

EntityObj::EntityObj(const char *data) {
    int size = strlen(data);
    this->data = new char[size + 1];

    memcpy(this->data, data, sizeof(char) * size);
    this->data[size] = 0;
}

EntityObj::~EntityObj() {
    if(nullptr != data)
        delete[] data;
}

EntityObj::EntityObj(EntityObj &other) {
    int size = strlen(other.data);
    this->data = new char[size + 1];

    memcpy(this->data, other.data, sizeof(char) * size);
    this->data[size] = 0;
}

Entity *EntityObj::clone() {
    return new EntityObj(*this);
}

ostream& operator<<(ostream& o,const EntityObj& e) {
    o << e.data;
    return o;
}