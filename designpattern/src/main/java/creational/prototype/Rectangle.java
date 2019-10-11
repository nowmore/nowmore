package creational.prototype;

public class Rectangle extends Shape {

    public Rectangle(String id) {
        setId(id);
        super.setType("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Rectangle::draw");
    }
}
