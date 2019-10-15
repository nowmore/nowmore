package structural.facade;

public class HtmlWriter {

    public void title(String title) {
        System.out.println("<html>\r\n<head><title>" + title + "</title></head>\r\n</html>");;
        System.out.println("<body><h1>" + title + "</h1>\n");
    }

    public void paragraph(String message) {
        System.out.println("<p>" + message + "</p>\n");
    }

    public void link(String href, String caption) {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mail, String name) {
        link("mailto:" + mail, name);
    }

    public void close() {
        System.out.println("</body>\r\n</html>\n");
    }
}
