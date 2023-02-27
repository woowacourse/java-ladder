package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int INITIAL_CAPACITY = 10;

    private String[] values;
    private final int capacity;


    public SimpleArrayList() {
        this.values = new String[INITIAL_CAPACITY];
        this.capacity = values.length;
    }

    @Override
    public boolean add(String value) {
        int size = calculateSize();
        if (size >= capacity) {
            increaseCapacity();
            values[size] = value;
            return true;
        }
        values[size] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        int size = calculateSize();
        if (size >= capacity) {
            increaseCapacity();
        }
        String[] currentValues = copyCurrentValues();
        values[index] = value;
        for (int i = index + 1; i <= size; i++) {
            values[i] = currentValues[i - 1];
        }
    }

    private String[] copyCurrentValues() {
        String[] currentValues = new String[capacity];
        for (int i = 0; i < calculateSize(); i++) {
            currentValues[i] = values[i];
        }
        return currentValues;
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

    private void increaseCapacity() {
        String[] currentValues = values;
        values = new String[capacity * 2];
        for (int index = 0; index < capacity; index++) {
            values[index] = currentValues[index];
        }
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
        return calculateSize();
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
