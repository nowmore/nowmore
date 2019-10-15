package behavioral.visitor;

public interface Element {
    abstract void accept(Visitor v);
}
