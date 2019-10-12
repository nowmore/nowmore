package creational.builder;

public abstract class ColdDrink implements Item {

    @Override
    public String name() {
        return this.getClass().getName();
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
