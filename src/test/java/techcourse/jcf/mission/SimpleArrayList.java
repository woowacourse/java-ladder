package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int initialValue = 10;

    private String[] arrayList;
    private int maxSize = initialValue;
    private int size = 0;

    public SimpleArrayList() {
        arrayList = new String[initialValue];
    }

    @Override
    public boolean add(String value) {
        size++;
        addValue(size - 1, value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        size++;
        addValue(index, value);
    }

    private void addValue(int index, String value) {
        validateIndex(index);
        if (size == maxSize) {
            grow();
        }
        arrayList[index] = value;
    }

    private void grow() {
        maxSize = maxSize * 2;
        arrayList = Arrays.copyOf(arrayList, maxSize);
    }

    private void validateIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        arrayList[index] = value;
        return arrayList[index];
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean contains(String value) {
        boolean isFound = false;
        for (int i = 0; i < size && !isFound; i++) {
            isFound = arrayList[i] == value;
        }
        return isFound;
    }

    @Override
    public int indexOf(String value) {
        boolean isFound = false;
        int index = 0;
        for (; index < size && !isFound; index++) {
            isFound = arrayList[index] == value;
        }
        if (isFound) {
            return index - 1;
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
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        removeByIndex(index);
        return true;
    }

    private void removeByIndex(int index) {
        for (; index < size - 1; index++) {
            arrayList[index] = arrayList[index + 1];
        }
        size--;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String value = arrayList[index];
        removeByIndex(index);
        return value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
