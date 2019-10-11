package creational.factoryMethod;

import creational.simpleFactory.NoSuchPizzaException;
import creational.simpleFactory.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) throws Exception {
        Pizza pizza = null;

        if(null == type) {
            throw new NullPointerException();
        }

        switch (type.toUpperCase()) {
            case "CHEESE":
                pizza = new NYCheesePizza();
                break;
            case "CLAM":
                pizza = new NYClamPizza();
                break;
            case "VEGGIE":
                pizza = new NYVeggiePizza();
                break;
            case "PEPPERONI":
                pizza = new NYPepperoniPizza();
            default:
                throw new NoSuchPizzaException();
        }

        return pizza;
    }
}
