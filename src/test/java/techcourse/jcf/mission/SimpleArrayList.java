package techcourse.jcf.mission;

import java.util.Objects;

public class SimpleArrayList implements SimpleList {

    public static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private int size;
    private String[] values;

    public SimpleArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.values = new String[INITIAL_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        if (size == capacity) {
            capacity += INITIAL_CAPACITY;
            add(size, value);
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, String value) {
        values[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < size) {
            return values[index] = value;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public String get(int index) {
        if (index < size) {
            return values[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(values[index], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(values[index], value)) {
                return index;
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
    public boolean remove(String findValue) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(values[index], findValue)) {
                remove(index);
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index < size) {
            String result = get(index);
            System.arraycopy(values, index + 1, values, index, size - index - 1);
            values[size - 1] = null;
            size--;
            return result;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void clear() {
        this.capacity = INITIAL_CAPACITY;
        size = 0;
        values = new String[capacity];
    }
}
