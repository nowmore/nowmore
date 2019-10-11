package behavioral.iterator;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {

    private ArrayList items;
    private int position = 0;

    public PancakeHouseMenuIterator(ArrayList items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        MenuItem item = (MenuItem) items.get(position);
        position++;
        return item;
    }

    @Override
    public void remove() {
        if(position <= 0 || position >= items.size()) {
            throw new IndexOutOfBoundsException();
        }
        items.remove(position);
        position--;
    }
}
