package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_SIZE = 10;

    private Object[] values;
    private int size;

    public SimpleArrayList() {
        values = new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public boolean add(String value) {
        if (size > values.length) {
            return false;
        }
        add(size, value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index == size) {
            expend();
        }

        values[index] = value;
        size = size + 1;
    }

    private void expend() {
        int newCapacity = values.length + (values.length >> 1);
        values = Arrays.copyOf(values, newCapacity);
    }

    @Override
    public String set(int index, String value) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        values[index] = value;
        return value;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return values[index].toString();
    }

    @Override
    public boolean contains(String value) {
        for (Object o : values) {
            if (o.toString().equals(value)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].toString().equals(value)) {
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
    public boolean remove(String value) {

        for (int i = 0; i < values.length; i++) {
            if (value.equals(values[i].toString())) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public String remove(int index) {
        String oldValue = values[index].toString();
        final int newSize;
        newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(values, index + 1, values, index, newSize - 1);
        }
        values[size] = null;
        size = newSize;

        return oldValue;
    }

    @Override
    public void clear() {
        Arrays.fill(values, null);
        size = 0;
    }
}
