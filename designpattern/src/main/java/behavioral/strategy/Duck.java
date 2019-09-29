package behavioral.strategy;


import behavioral.strategy.behavior.FlyBehavior;
import behavioral.strategy.behavior.QuackBehavior;

//设计原则
//1.找到应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
//本例中duck的behavior会随鸭子的不同而改变，故将其独立成两个接口
//2.针对接口编程，而不是针对实现编程
public abstract class  Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All duck float, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
