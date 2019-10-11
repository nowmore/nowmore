package creational.singleton;

public class Singleton {

    private static Singleton instance;
    private int id = 0;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public int getUID() {
        return id++;
    }

    public static void main(String[] args) {
        Singleton o1 = Singleton.getInstance();
        Singleton o2 = Singleton.getInstance();

        System.out.println(o1.getUID());
        System.out.println(o2.getUID());
    }
}
