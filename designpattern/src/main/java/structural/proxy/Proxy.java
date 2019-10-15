package structural.proxy;

public class Proxy implements Image {

    private RealImage image;
    private String name;

    public Proxy(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(name);
        }
        image.display();
    }

    public static void main(String[] args) {
        new Proxy("test.jpg").display();
    }
}
