package structural.bridge;

//类的实现层次
//Implementor 定义了用于Abstraction的接口
public abstract class DisplayImpl {
    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}
