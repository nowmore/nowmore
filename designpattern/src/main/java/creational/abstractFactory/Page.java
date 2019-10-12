package creational.abstractFactory;

import java.util.ArrayList;

public abstract class Page {

    protected String title;
    protected String author;
    protected ArrayList content = new ArrayList();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
            System.out.println( title + ".html");

            System.out.println(makeHTML());
    }

    public abstract String makeHTML();
}
