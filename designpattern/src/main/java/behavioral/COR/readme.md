# 责任链模式 Chain of Responsibility 
---

## 模式定义
为请求创建了一个由若干个接收者对象组成的链，请求沿着链传递，直到被处理或达到链尾被丢弃。


## 模式结构

1. Handler
2. ConcreteHandler

![avatar](https://github.com/nowmore/resource/blob/master/dp/chain_of_responsibility.jpg?raw=true)

## 模式分析
1. 关键代码
- 除链尾，每个Handler都有其他Handler实例的引用
```
Handler& Handler::setNext(Handler &h) {
    next = &h;
    return h;
}

```
- 传递请求
```
void Handler::handle(Req &r) {
    if (operation(r)) {
        //pass;
    } else if (NULL != next) {
        next->handle(r);
    } else {
        //failed;
    }
} 
```
## 模式优点
 1. 降低耦合度。它将请求的发送者和接收者解耦   
 2. 简化了对象。使得对象不需要知道链的结构 
 3. 增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任   
 4. 增加新的请求处理类很方便。
 
## 模式缺点
 1. 不能保证请求一定被接收。    
 2. 系统性能将受到一定影响   
 3. 可能不容易观察运行时的特征，有碍于除错

