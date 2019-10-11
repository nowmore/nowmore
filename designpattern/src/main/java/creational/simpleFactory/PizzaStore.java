package creational.simpleFactory;

public class PizzaStore {
    private PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public void orderPizza(String type) throws Exception{
        Pizza pizza = factory.createPizza(type);
        pizza.orderPizza();
    }

    public static void main(String[] args) throws Exception {
        PizzaStore ps = new PizzaStore(new SimplePizzaFactory());
        ps.orderPizza("cheese");
        ps.orderPizza("veggie");
        ps.orderPizza("clam");
    }
}
