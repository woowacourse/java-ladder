package listmission.list;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int tailCursor;

    public SimpleArrayList() {
        this.elements = new String[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        beforeAdd(value);

        elements[tailCursor] = value;
        tailCursor += 1;
        return true;
    }

    @Override
    public void add(int index, String value) {
        checkIndex(index);
        beforeAdd(value);

        int copySize = elements.length;
        String[] copy = new String[copySize];
        for (int i = 0; i < copySize; i++) {
            if (i < index) {
                copy[i] = elements[i];
            }

            if (i == index) {
                copy[i] = value;
                continue;
            }

            if (i > index) {
                copy[i] = elements[i - 1];
            }
        }

        tailCursor += 1;
        this.elements = copy;
    }

    private void beforeAdd(String value) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (elements.length <= tailCursor) {
            String[] copy = new String[elements.length + DEFAULT_CAPACITY];
            for (int i = 0; i < tailCursor; i++) {
                copy[i] = elements[i];
            }
            this.elements = copy;
        }
    }

    @Override
    public String set(int index, String value) {
        try {
            checkIndex(index);
            assert this.elements[index] != null;

            elements[index] = value;
            return value;
        } catch (AssertionError assertionError) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String get(int index) {
        try {
            checkIndex(index);

            return this.elements[index];
        } catch (AssertionError assertionError) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(String value) {
        return Arrays.stream(elements)
                .filter(Objects::nonNull)
                .anyMatch(it -> it.equals(value));
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(value)) {
                return i;
            }
        }

        throw new NullPointerException();
    }

    @Override
    public int size() {
        return (int) Arrays.stream(this.elements)
                .filter(Objects::nonNull)
                .count();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String removeValue = get(index);
        int copySize = elements.length - 1;
        String[] copy = new String[copySize];
        for (int i = 0; i < copySize; i++) {
            if (i < index) {
                copy[i] = elements[i];
            }

            if (i == index) {
                continue;
            }

            if (i > index) {
                copy[i - 1] = elements[i];
            }
        }

        this.elements = copy;
        return removeValue;
    }

    @Override
    public void clear() {
        elements = new String[DEFAULT_CAPACITY];
    }

    private void checkIndex(int index) {
        if (!(0 <= index && index < size())) {
            throw new IndexOutOfBoundsException();
        }
    }
}
