package minimission;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_ARRAY_SIZE = 10;
    private static final int DEFAULT_GROW_SIZE = 5;

    private String[] elements;
    private int position;

    public SimpleArrayList() {
            this.elements = new String[DEFAULT_ARRAY_SIZE];
            this.position = 0;
    }

    public boolean add(String value) {
        if (needToGrow()) {
            growOneTime();
        }
        elements[position++] = value;
        return true;
    }

    public void add(int index, String value) {
        if (needToGrow()) {
            growOneTime();
        }
        shiftAllElementRightFrom(index);
        elements[index] = value;
        position++;
    }

    private boolean needToGrow() {
        return elements.length <= position;
    }

    private void growOneTime() {
        String[] newElements = new String[elements.length + DEFAULT_GROW_SIZE];

        for (int i = position - 1; i >= 0; i--) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void shiftAllElementRightFrom(int index) {
        for (int i = position; i > index; i--) {
            elements[i] = elements[i-1];
        }
    }

    private void shiftAllElementLeftFrom(int index) {
        for (int i = index + 1; i < position; i++) {
            elements[i-1] = elements[i];
        }
    }

    public String set(int index, String value) {
        String removedElement = elements[index];
        elements[index] = value;
        return removedElement;
    }

    public String get(int index) {
        return elements[index];
    }

    public boolean contains(String value) {
        return Stream.iterate(0, i -> i + 1)
                .limit(position)
                .anyMatch(i -> elements[i].equals(value));
    }

    public int indexOf(String value) {
        return Stream.iterate(0, i -> i + 1)
                .limit(position)
                .filter(i -> elements[i].equals(value))
                .findFirst()
                .orElse(-1);
    }

    public int size() {
        return position;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    public boolean remove(String value) {
        int targetIndex = indexOf(value);
        shiftAllElementLeftFrom(targetIndex);
        position--;
        return true;
    }

    public String remove(int index) {
        String removedElement = elements[index];
        shiftAllElementLeftFrom(index);
        position--;
        return removedElement;
    }

    public void clear() {
        elements = new String[DEFAULT_ARRAY_SIZE];
        position = 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");

        for (int i = 0; i < position; i++) {
            stringJoiner.add(elements[i]);
        }
        return stringJoiner.toString();
    }
}
