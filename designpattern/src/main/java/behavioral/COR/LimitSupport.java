package behavioral.COR;

public class LimitSupport extends Support {
    private int limit;
    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNum() < limit;
    }
}
