package behavioral.iterator;

public class DinerMenuIterator implements Iterator {
    private MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.items = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public Object next() {
        MenuItem item = items[position];
        ++position;
        return item;
    }

    @Override
    public void remove() {
        if(position <= 0) {
            throw new IndexOutOfBoundsException();
        }
        items[position - 1] = null;
        --position;
    }
}
