package creational.abstractFactory;

import java.util.Iterator;

public class TablePage extends Page {

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {

        StringBuffer buffer =  new StringBuffer();

        buffer.append("<html><head><title>" + title + "</title></head></html>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<table width=\"80%\" border=\"3\">\n");

        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append("<tr>" + item.makeHTML() + "</tr>");
        }

        buffer.append("</table>");
        buffer.append("<hr><address>" + author + "</address>\n");
        buffer.append("</body>\n</html>\n");

        return buffer.toString();
    }
}
