package structural.adapter;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }

    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();

        Duck adapter = new TurkeyAdapter(turkey);

        turkey.gobble();
        turkey.fly();

        adapter.quack();
        adapter.fly();
    }
}
