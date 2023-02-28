package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static int DEFAULT_CAPACITY = 10;

    private String[] DEFAULT_ARRAY = {};
    private String[] elements;
    private int capacity = 0;
    private int size = 0;

    public SimpleArrayList() {
        elements = DEFAULT_ARRAY;
    }

    @Override
    public boolean add(String value) {
        if (size == 0) {
            elements = new String[DEFAULT_CAPACITY];
            capacity = DEFAULT_CAPACITY;
        }

        if (size >= capacity) {
            elements = Arrays.copyOf(elements, (capacity >> 1));
            capacity = (capacity >> 1);
        }

        elements[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size >= capacity) {
            elements = Arrays.copyOf(elements, (capacity >> 1));
            capacity = (capacity >> 1);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String temp = elements[index];
        elements[index] = value;
        return temp;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return elements[index];
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(value)) {
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
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(value)) {
                System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
                size--;
                elements[size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String temp = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;
        elements[size] = null;
        return temp;

    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            elements[index] = null;
        }
        size = 0;
        capacity = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}
