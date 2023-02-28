package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {


    private static final int INITIAL_SIZE = 10;
    private int size;
    private String[] stores;

    public SimpleArrayList() {
        size = 0;
        this.stores = new String[INITIAL_SIZE];
    }

    @Override
    public boolean add(final String value) {
        if (stores.length > size) {
            resize();
        }
        stores[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(final int index, final String value) {
        isInRange(index);
        if (stores.length == size) {
            resize();
        }
        if (index == size) {
            add(value);
            return;
        }
        for (int i = size; i > index; i--) {
            stores[i] = stores[i - 1];
        }
        stores[index] = value;
        size++;
    }

    @Override
    public String set(final int index, final String value) {
        isInRange(index);
        final String oldValue = stores[index];
        stores[index] = value;
        return oldValue;
    }


    @Override
    public String get(final int index) {
        isInRange(index);
        return stores[index];
    }

    @Override
    public boolean contains(final String value) {
        if (indexOf(value) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(final String value) {
        int i;

        for (i = 0; i < size; i++) {
            if (stores[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(final String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String remove(final int index) {
        isInRange(index);
        String oldValue = stores[index];
        stores[index] = null;

        for (int i = index; i < size - 1; i++) {
            stores[i] = stores[i + 1];
            stores[i + 1] = null;
        }
        size--;
        resize();
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stores[i] = null;
        }
        size = 0;
        resize();
    }

    private void resize() {
        String[] emptyArray = {};

        if (Arrays.equals(stores, emptyArray)) {
            stores = new String[INITIAL_SIZE];
            return;
        }

        if (this.size == stores.length) {
            stores = Arrays.copyOf(stores, stores.length + INITIAL_SIZE);
            return;
        }

        if (this.size < (stores.length / 2)) {
            stores = Arrays.copyOf(stores, stores.length / 2);
            return;
        }

    }

    private void isInRange(final int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
