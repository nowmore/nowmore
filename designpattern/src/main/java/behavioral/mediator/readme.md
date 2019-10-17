# 中介模式 Mediator
---

## 模式定义
用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。中介者模式又称为调停者模式，它是一种对象行为型模式。

2.3. 模式结构
中介者模式包含如下角色：

1. Mediator: 抽象中介者
2. ConcreteMediator: 具体中介者
3. Colleague: 抽象同事类
4. ConcreteColleague: 具体同事类

![avatar](https://github.com/nowmore/resource/blob/master/dp/mediator.jpg?raw=true)


## 模式优点
1. 简化了对象之间的交互。
2. 将各同事解耦。
3. 减少子类生成。
4. 可以简化各同事类的设计和实现。

## 模式缺点
在具体中介者类中包含了同事之间的交互细节，可能会导致具体中介者类非常复杂，使得系统难以维护。