package minimission;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SimpleArrayList implements SimpleList{

    private static final int DEFAULT_SIZE = 16;

    private String[] elements;
    private int size;
    private int position;

    public SimpleArrayList() {
        this.elements = new String[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
        this.position = 0;
    }

    @Override
    public boolean add(String value) {
        checkCapacity();

        try {
            elements[position++] = value;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void add(int index, String value) {
        checkCapacity();
        validateIndexOutOfRange(index);

        position++;

        String[] newElements = new String[size];
        for (int i = 0; i < index - 1; i++) {
            newElements[i] = elements[i];
        }
        newElements[index] = value;
        for (int i = index + 1; i < position; i++) {
            newElements[i] = elements[i - 1];
        }

        elements = newElements;
    }

    @Override
    public String set(int index, String value) {
        validateIndexOutOfRange(index);

        String originalValue = elements[index];
        elements[index] = value;
        return originalValue;
    }

    @Override
    public String get(int index) {
        validateIndexOutOfRange(index);

        return elements[index];
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < position; index++) {
            if (elements[index].equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < position; index++) {
            if (elements[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public boolean remove(String value) {
        if (!contains(value)) {
            throw new NoSuchElementException();
        }
        int index = indexOf(value);
        try {
            for (int i = index; i < position - 1; i++) {
                elements[i] = elements[i + 1];
            }
            position--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String remove(int index) {
        validateIndexOutOfRange(index);
        String removedValue = elements[index];

        for (int i = index; i < position - 1; i++) {
            elements[i] = elements[i + 1];
        }
        position--;

        return removedValue;
    }

    @Override
    public void clear() {
        elements = new String[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
        position = 0;
    }

    private void checkCapacity() {
        if (position == size) {
            size = 2 + size + 1;
            elements = Arrays.copyOf(elements, size);
        }
    }

    private void validateIndexOutOfRange(int index) {
        if (index < 0 || index >= position) {
            throw new IndexOutOfBoundsException();
        }
    }
}
