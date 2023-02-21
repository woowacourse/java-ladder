package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int INITIAL_CAPACITY = 10;

    private String[] data;
    private int size;

    public SimpleArrayList() {
        initData();
    }

    private void ensureCapacity() {
        if (size == data.length) {
            growCapacity();
        }
    }

    private void growCapacity() {
        final int oldCapacity = data.length;
        final int newCapacity = oldCapacity + (oldCapacity >> 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public boolean add(String value) {
        ensureCapacity();
        data[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        final String oldValue = data[index];
        data[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return data[index];
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
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
    public boolean remove(String value) {
        final int targetIndex = indexOf(value);
        if (targetIndex == -1) {
            return false;
        }
        forceRemove(targetIndex);
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        return forceRemove(index);
    }

    private String forceRemove(int index) {
        final String removedValue = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removedValue;
    }

    @Override
    public void clear() {
        initData();
    }

    private void initData() {
        this.data = new String[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
