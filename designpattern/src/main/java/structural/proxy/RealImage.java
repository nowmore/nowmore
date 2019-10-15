package structural.proxy;

public class RealImage implements Image {

    private String name;

    public RealImage(String name) {
        this.name = name;
        System.out.println("Loading " + name);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + name);
    }
}
