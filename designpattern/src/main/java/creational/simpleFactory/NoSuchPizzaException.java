package creational.simpleFactory;

public class NoSuchPizzaException extends Exception {

    public NoSuchPizzaException() {

    }

    public NoSuchPizzaException(String message) {
        super(message);
    }
}
