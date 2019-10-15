# 桥接模式 Bridge Pattern


## 模式定义
将抽象部分与它的实现部分分离，使它们都可以独立地变化。

## 模式结构
桥接模式包含如下角色：
   
* Abstraction：抽象类
* RefinedAbstraction：扩充抽象类
* Implementor：实现类接口
* ConcreteImplementor：具体实现类  

![avatar](https://github.com/nowmore/resource/blob/master/dp/bridge.jpg?raw=true)


## 模式优点
1. 抽象和实现的分离。 
2. 优秀的扩展能力。 
3. 实现细节对客户透明。

## 模式缺点
1. 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，
通过桥接模式可以使它们在抽象层建立一个关联关系。    
2. 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。    
3. 一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。












