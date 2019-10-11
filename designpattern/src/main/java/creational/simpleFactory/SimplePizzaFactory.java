package creational.simpleFactory;

public class SimplePizzaFactory  implements  PizzaFactory{

    public Pizza createPizza(String type) throws Exception{
        Pizza pizza = null;

        if(null == type) {
            throw new NullPointerException();
        }

        switch (type.toUpperCase()) {
            case "CHEESE":
                pizza = new CheesePizza();
                break;
            case "CLAM":
                pizza = new ClamPizza();
                break;
            case "VEGGIE":
                pizza = new VeggiePizza();
                break;
            default:
                throw new NoSuchPizzaException();
        }

        return pizza;
    }
}
