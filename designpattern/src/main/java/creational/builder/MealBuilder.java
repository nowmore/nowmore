package creational.builder;

public class MealBuilder {

    public Meal buildVegMeal() {
        StringBuilder builder;
        Meal meal = new Meal();

        meal.addItem(new VegBurger());
        meal.addItem(new Coke());

        return meal;
    }

    public Meal buildNonVegMeal() {
        Meal meal = new Meal();

        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());

        return meal;
    }

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal m1 = builder.buildNonVegMeal();
        m1.show();
        System.out.println("Total cost: " + m1.getCost());

        Meal m2 = builder.buildVegMeal();

        m2.show();
        System.out.println("Total cost: " + m2.getCost());
    }
}
