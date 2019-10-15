package structural.facade;

import java.util.Properties;

public class PageMaker {
    private PageMaker() {

    }

    public static void makePage(String mail) throws Exception{
        Properties properties = Database.getProperties();
        String name = properties.getProperty(mail);
        HtmlWriter writer = new HtmlWriter();

        writer.title("Welcome to " + name + "'s Page!");
        writer.paragraph(name + " welcome to " + name + "'s Page");
        writer.paragraph("Hello World");
        writer.mailto(mail, name);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        PageMaker.makePage("x@abc.com");
    }
}
