package structural.bridge;

public class Demo {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, 1!"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, 2!"));

        d1.display();
        d2.display();

        ((CountDisplay)d2).multiDisplay(5);
    }
}
