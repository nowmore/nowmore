package behavioral.COR;

public class Trouble {
    private int num;

    public Trouble(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "[Trouble: " + num + ']';
    }
}
