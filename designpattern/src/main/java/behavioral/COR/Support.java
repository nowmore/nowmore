package behavioral.COR;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble t) {
        if (resolve(t)) {
            done(t);
        } else if (next != null) {
            next.support(t);
        } else {
            fail(t);
        }
    }

    protected abstract boolean resolve(Trouble t);

    protected void done(Trouble t) {
        System.out.println(t + " is resolved by " + this + ".");
    }

    protected void fail(Trouble t) {
        System.out.println(t + " cannot be resolved.");
    }

    @Override
    public String toString() {
        return "[" + name +"]";
    }
}
