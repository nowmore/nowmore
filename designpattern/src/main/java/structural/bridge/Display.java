package structural.bridge;

//类的功能层次
//Abstraction 使用 Implementor的基本功能
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public void display() {
        open();
        print();
        close();
    }
}
