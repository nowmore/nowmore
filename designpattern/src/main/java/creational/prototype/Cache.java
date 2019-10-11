package creational.prototype;

import java.util.Hashtable;

public class Cache {

    private static Hashtable<String, Shape> cache
            = new Hashtable<>();

    public static Shape getShape(String Id) {
        return (Shape)cache.get(Id).clone();
    }

    public static void load() {
        Square square = new Square("1");
        Rectangle rec = new Rectangle("2");
        cache.put(square.getId(), square);
        cache.put(rec.getId(), rec);
    }

    public static void main(String[] args) {
        Cache.load();

        Shape o1 = Cache.getShape("1");
        Shape o2 = Cache.getShape("2");

        System.out.println(o1.getType());
        System.out.println(o2.getType());
    }
}
