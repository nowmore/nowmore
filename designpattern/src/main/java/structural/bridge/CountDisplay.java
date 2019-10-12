package structural.bridge;

//RefinedAbstraction 在Abstraction角色的基础上添加新的功能
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    //新功能
    public void multiDisplay(int times) {
        open();

        for (int i=0; i<times; i++) {
            print();
        }

        close();
    }
}
