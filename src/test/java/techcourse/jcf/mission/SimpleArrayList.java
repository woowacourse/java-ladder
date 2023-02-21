package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private String[] array = new String[10];
    private int endIndex = 0;
    private int capacity = 10;

    @Override
    public boolean add(String value) {
        if (endIndex < capacity) {
            array[endIndex++] = value;
            return true;
        }

        addCapacity();
        return add(value);
    }

    private void addCapacity() {
        if (((long) this.capacity << 1) > Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        }

        int newCapacity = capacity << 1;
        String[] newArray = new String[newCapacity];

        for (int i = 0; i < endIndex; i++) {
            newArray[i] = array[i];
        }

        this.array = newArray;
        this.capacity = newCapacity;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);

        if (endIndex == capacity) {
            addCapacity();
        }

        String[] copy = copyOf(index);

        array[index] = value;
        endIndex++;
        for (int i = index + 1; i < endIndex; i++) {
            array[i] = copy[i - index - 1];
        }
    }

    private String[] copyOf(int startIndex) {
        String[] copyOf = new String[capacity - startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            copyOf[i - startIndex] = array[i];
        }

        return copyOf;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= endIndex) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);

        String previous = array[index];
        array[index] = value;

        return previous;
    }

    @Override
    public String get(int index) {
        validateIndex(index);

        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return endIndex;
    }

    @Override
    public boolean isEmpty() {
        return endIndex == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = -1;
        for (int i = 0; i < endIndex; i++) {
            if (array[i].equals(value)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        String[] copy = copyOf(index + 1);
        endIndex--;
        for (int i = index; i < endIndex; i++) {
            array[i] = copy[i - index];
        }

        return true;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String previous = array[index];

        String[] copy = copyOf(index + 1);
        endIndex--;
        for (int i = index; i < endIndex; i++) {
            array[i] = copy[i - index];
        }

        return previous;
    }

    @Override
    public void clear() {
        array = new String[10];
        endIndex = 0;
        capacity = 10;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, endIndex));
    }
}
