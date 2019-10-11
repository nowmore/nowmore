package behavioral.template;

public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.println("<<");
    }

    @Override
    void print() {
        System.out.println(ch);
    }

    @Override
    void close() {
        System.out.println(">>");
    }
}
