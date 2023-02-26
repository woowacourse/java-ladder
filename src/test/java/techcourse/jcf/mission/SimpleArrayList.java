package techcourse.jcf.mission;

import java.util.*;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final String[] EMPTY_ELEMENTDATA = {};

    private String[] elementData;
    private int size;

    public SimpleArrayList() {
        this.elementData = new String[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        add(value, elementData, size);
        return true;
    }

    private void add(String value, String[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = value;
        size = s + 1;
    }

    private String[] grow() {
        return grow(size + 1);
    }

    private String[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return newCapacity;
    }

    @Override
    public void add(int index, String value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("[ERROR] index 범위가 현재 리스트 범위를 넘어섰습니다.");
        }
        if (size == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size - index);
        elementData[index] = value;
        size = size + 1;
    }

    @Override
    public String set(int index, String element) {
        Objects.checkIndex(index, size);
        String oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public String get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (value == null && elementData[i] == null) {
                return i;
            }
            if (value.equals(elementData[i])) {
                return i;
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
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        for (int i = 0; i < size; i++) {
            if (value == null && elementData[i] == null) {
                move(elementData, i);
                return true;
            }
            if (value.equals(elementData[i])) {
                move(elementData, i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        Objects.checkIndex(index, size);
        String oldValue = elementData[index];
        move(elementData, index);
        return oldValue;
    }

    private void move(String[] elementData ,int index) {
        if (size - 1 > index) {
            System.arraycopy(elementData, index + 1,
                    elementData, index,
                    size - index);
        }
        elementData[size = size - 1] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i ++) {
            elementData[i] = null;
        }
        size = 0;
    }
}
