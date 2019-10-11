package creational.simpleFactory;

public interface PizzaFactory {

    Pizza createPizza(String type) throws Exception;
}
