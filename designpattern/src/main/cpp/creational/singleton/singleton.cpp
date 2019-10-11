#include "singleton.h"

#include <iostream>
#include <mutex>
using std::mutex;

mutex lock;
singleton *singleton::instance = NULL;
//int singleton::id = 0;
singleton::singleton() {
    id = 0;
}

singleton::~singleton() {

}

singleton *singleton::getInstance() {

    if(NULL == instance) {
        lock.lock();
        if(NULL == instance) {
            instance = new singleton;
        }
        lock.unlock();
    }
    return instance;
}

void singleton::release() {
        if(NULL != instance) {
        lock.lock();
        if(NULL != instance) {
            delete instance;
        }
        lock.unlock();
    }
}

int singleton::getUID() {
    lock.lock();
    ++id;
    lock.unlock();
    return id;
}