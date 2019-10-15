# 访问者模式 Visitor
---

## 模式定义
将数据结构与数据操作分离

## 模式分析
1. 关键代码： **双重分发**
Element::accept(Visitor&)
Visitor::visit(Element&)

## 模式结构
1. Visitor   
负责对数据结构中的每个具体的元素声明一个用于访问的方法   
2. ConcreteVisitor   
负责实现Visitor所定义的接口   
3. Element   
Visitor的访问对象，声明了接受Visitor的方法accept   
4. ConcreteElement   
负责实现Element所定义的接口   
5. ObjectStructure   
负责处理Element角色的集合

![avatar](https://github.com/nowmore/resource/blob/master/dp/visitor.jpg?raw=true)

## 模式优点
1. 符合单一职责原则。 
2. 优秀的扩展性。 
3. 灵活性。

## 模式缺点
1. 具体元素对访问者公布细节，违反了迪米特原则。 
2. 具体元素变更比较困难。 
3. 违反了依赖倒置原则，依赖了具体类，没有依赖抽象。
