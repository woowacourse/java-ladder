package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
        int size = size();
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
        int size = size();
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
        for (int i = 0; i < size(); i++) {
            currentValues[i] = values[i];
        }
        return currentValues;
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
        String currentValue = values[index];
        values[index] = value;
        return currentValue;
    }

    @Override
    public String get(int index) {
        validateIndexInBounds(index);
        return values[index];
    }

    private void validateIndexInBounds(final int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(String value) {
        for (String element : values) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < size(); index++) {
            if (values[index].equals(value)) {
                return index;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        int size = 0;
        for (String element : values) {
            if (element != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(String value) {
        try {
            int index = indexOf(value);
            remove(index);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }

    }

    @Override
    public String remove(int index) {
        validateIndexInBounds(index);
        String removeValue = values[index];
        String[] currentValues = copyCurrentValues();
        for (int i = index; i < size() - 1; i++) {
            values[i] = currentValues[i + 1];
        }
        values[size() - 1] = null;
        return removeValue;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size(); index++) {
            values[index] = null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
