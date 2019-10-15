# 组合模式 Composite

又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次

**能够使容器与内容具有一致性，创造出递归结构**

## 模式结构
组合模式包含以下角色：
1. Leaf(叶节点)   
内容角色，被Composite所包含，叶子节点，无法包含其他角色   
2. Composite   
容器角色，可包含Leaf和Composite
3. Component  
Leaf和Composite的共同父类，使得Leaf和Composite具有一致性

![avatar](https://github.com/nowmore/resource/blob/master/dp/composite.jpg?raw=true)

## 模式优点
1. 高层模块调用简单
2. 节点自由增加

## 模式缺点
1. 在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。
