package behavioral.template;

public class Main {

    public static void main(String[] args) {
        AbstractDisplay ch = new CharDisplay('H');
        AbstractDisplay str = new StringDisplay("Hello World");

        ch.display();
        str.display();
    }

}
