package techcourse.icf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static int DEFAULT_CAPACITY = 10;

    private int size;
    private int capacity;
    private String[] values;

    public SimpleArrayList() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        values = new String[DEFAULT_CAPACITY];
    }

    private void add(int index, String value, int s) {
        if (s == capacity) {
            capacity += capacity / 2;
            values = Arrays.copyOf(values, capacity);
        }
        System.arraycopy(values, index, values, index + 1, s - index);
        values[index] = value;
        size = s + 1;
    }

    private void remove(int index, int s) {
        if (size - 1 > index) {
            System.arraycopy(values, index + 1, values, index, size);
        }
        values[size - 1] = null;
        size = s - 1;
    }

    @Override
    public boolean add(String value) {
        add(size, value, size);
        return true;
    }

    @Override
    public void add(int index, String value) {
        add(index, value, size);
    }

    @Override
    public String set(int index, String value) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        values[index] = value;
        return value;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public boolean contains(String value) {
        return Arrays.stream(values).anyMatch((val) -> val.equals(value));
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
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
        if (indexOf(value) == -1) {
            return false;
        }
        remove(indexOf(value), size);
        return true;
    }

    @Override
    public String remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String result = get(index);
        remove(index, size);
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        values = new String[capacity];
    }
}
