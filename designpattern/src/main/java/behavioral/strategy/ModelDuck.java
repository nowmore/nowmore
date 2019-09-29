package behavioral.strategy;


import behavioral.strategy.behavior.FlyNoWay;
import behavioral.strategy.behavior.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior  = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck!");
    }
}
