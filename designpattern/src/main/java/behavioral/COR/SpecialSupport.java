package behavioral.COR;

public class SpecialSupport extends Support {

    private int num;

    public SpecialSupport(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNum() == num;
    }
}
