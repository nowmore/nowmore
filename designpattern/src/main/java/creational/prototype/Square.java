package creational.prototype;

public class Square extends Shape {

    public Square(String id) {
        setId(id);
        super.setType("Square");
    }

    @Override
    public void draw() {
        System.out.println("Square::draw");
    }
}
