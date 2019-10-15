package behavioral.COR;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNum() % 2 == 1;
    }
}
