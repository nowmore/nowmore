package creational.factoryMethod;

import creational.simpleFactory.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) throws Exception {

        Pizza pizza = createPizza(type);
        pizza.orderPizza();
        return pizza;
    }

    abstract Pizza createPizza(String type) throws Exception;
}
