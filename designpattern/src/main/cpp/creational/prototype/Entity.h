#ifndef __ENTITY_H__
#define __ENTITY_H__

class Entity
{
private:
    /* data */
public:
    Entity(){};
    virtual ~Entity(){};

    virtual Entity *clone() = 0;
};


#endif//;__ENTITY_H__