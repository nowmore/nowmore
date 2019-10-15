package structural.flyweight;

import java.util.HashMap;
import java.util.function.Function;

public class ShapeFactory {

    private static final HashMap<String, Shape> cache
            = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle c = (Circle) cache.get(color);

        if (c == null) {
            c = new Circle(color);
            cache.put(color, c);
        }
        return c;
    }

    public static int random() {
        return (int)Math.random();
    }

    public static void main(String[] args) {
        final String colors[] = {
          "Red", "Green", "Blue", "White", "Black"
        };

        for (int i=0; i<20; i++) {
            ShapeFactory.getCircle(colors[(int)(Math.random()* colors.length)]).draw();
        }
    }
}
