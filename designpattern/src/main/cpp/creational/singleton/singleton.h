#ifndef __SIGNLETON_H__
#define __SIGNLETON_H__

class singleton
{
private:
    singleton();

private:
    static singleton *instance;

    int id;
public:
    ~singleton();
    static singleton *getInstance();
    static void release();

    int getUID();
};

#endif//;__SIGNLETON_H__