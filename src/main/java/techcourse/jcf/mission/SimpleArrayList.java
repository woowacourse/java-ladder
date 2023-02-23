package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private int currentCapacity = DEFAULT_CAPACITY;
    private String[] values;

    public SimpleArrayList() {
        values = new String[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(final String[] values) {
        this.currentCapacity = values.length;
        this.size = values.length;
        this.values = values.clone();
    }

    @Override
    public boolean add(final String value) {
        if (size == currentCapacity) {
            extendCapacity();
        }
        values[size++] = value;
        return true;
    }

    //TODO: add한 index 뒤에 있는 값들을 전부 이동 시키기
    @Override
    public void add(final int index, final String value) {
        if (size == currentCapacity) {
            extendCapacity();
        }
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size += 1;
    }

    @Override
    public String set(final int index, final String value) {
        final String previousValue = values[index];
        values[index] = value;
        return previousValue;
    }

    @Override
    public String get(final int index) {
        return values[index];
    }

    @Override
    public boolean contains(final String value) {
        for (String storedValue : values) {
            if (storedValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final String value) {
        for (int index = 0; index < size; index++) {
            if (values[index].equals(value)) {
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
    public boolean remove(final String value) {
        for (int index = 0; index < size; index++) {
            if (values[index].equals(value)) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(final int index) {
        final String removedValue = values[index];
        size -= 1;
        System.arraycopy(values, index + 1, values, index, size - index);
        values[size] = null;
        return removedValue;
    }

    @Override
    public void clear() {
        values = new String[0];
        size = 0;
    }

    private void extendCapacity() {
        this.values = Arrays.copyOf(this.values, currentCapacity * 2);
    }
}
