package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private List<Memento> mementos = new ArrayList<>();

    public void save(Memento m) {
        mementos.add(m);
    }

    public Memento load(int index) {
        return mementos.get(index);
    }

    public static void main(String[] args) {
        Originator o = new Originator("State#1");

        CareTaker c = new CareTaker();

        c.save(o.saveState());
        o.setState("State#2");
        c.save(o.saveState());
        o.setState("State#3");

        System.out.println("Current state:" + o.getState());
        o.resetState(c.load(0));
        System.out.println("First state: " + o.getState());
        o.resetState(c.load((1)));
        System.out.println("Second state: " + o.getState());
    }
}
