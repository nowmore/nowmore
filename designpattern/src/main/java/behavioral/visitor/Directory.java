package behavioral.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {

    private String name;
    private ArrayList<Entry> dir = new ArrayList<Entry>();

    public Directory(String name) {
        this.name = name;
    }

    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;

        for(Object e : dir) {
            size += ((Entry)e).getSize();
        }

        return size;
    }

    @Override
    public Iterator iterator() {
        return dir.iterator();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
