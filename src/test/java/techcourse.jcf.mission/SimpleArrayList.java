package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int INITIAL_CAPACITY = 10;
    private String[] values;

    public SimpleArrayList() {
        this.values = new String[INITIAL_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        int capacity = calculateCapacity();
        int size = calculateSize();
        if (size >= capacity) {
            increaseCapacity(capacity);
            values[size] = value;
            return true;
        }
        values[size] = value;
        return true;
    }

    private int calculateCapacity() {
        return values.length;
    }

    private int calculateSize() {
        int currentSize = 0;
        for (String element : values) {
            if (element != null) {
                currentSize++;
            }
        }
        return currentSize;
    }

    private void increaseCapacity(int capacity) {
        String[] currentValues = values;
        values = new String[capacity * 2];
        for (int index = 0; index < calculateCapacity(); index++) {
            values[index] = currentValues[index];
        }
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
