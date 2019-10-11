package creational.simpleFactory;

import java.util.ArrayList;

public abstract class Pizza {

    private String name;
    private String dough;
    private String sauce;

    ArrayList toppings = new ArrayList();

    public Pizza(String name) {
        this.name = name;
    }

    public void prepare() {

        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");

        toppings.forEach(o->System.out.println(" " + o));
    }

    public void bake() {
        System.out.println("Bake " + name + " for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting " + name + "into diagonal slices");
    }

    public void box() {
        System.out.println("Place " + name +" in official PizzaStore box");
    }

    public void orderPizza() {
        prepare();
        bake();
        cut();
        box();
    }

}
