package behavioral.strategy;


import behavioral.strategy.behavior.FlyWithWings;
import behavioral.strategy.behavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real mallard duck");
    }
}
