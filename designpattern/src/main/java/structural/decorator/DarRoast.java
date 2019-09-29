package structural.decorator;

public class DarRoast extends Beverage {


    @Override
    public String getDescription() {
        return "Dark Roast";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
