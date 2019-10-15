package structural.composite;

import java.util.ArrayList;

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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);

        for(Object o : dir) {
            ((Entry)o).printList(prefix + "/" + name);
        }
    }
}
