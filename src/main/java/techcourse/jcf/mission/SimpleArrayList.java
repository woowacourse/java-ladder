package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final String[] EMPTY_ELEMENT_DATA = {};

    private String[] elementData;
    private int size;

    public SimpleArrayList() {
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    public SimpleArrayList(String[] elementData) {
        this.elementData = elementData;
        this.size = elementData.length;
    }

    @Override
    public boolean add(String value) {
        resizeCapacity(size + 1);
        elementData[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndexRange(index);
        resizeCapacity(size + 1);
        fastAdd(index);
        elementData[index] = value;
        size++;
    }

    private void resizeCapacity(int minCapacity) {
        int newCapacity = computeCapacity(elementData, minCapacity);
        if (newCapacity > elementData.length) {
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private int computeCapacity(String[] elementData, int minCapacity) {
        if (elementData == EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void fastAdd(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    @Override
    public String set(int index, String value) {
        validateIndexRange(index);
        String previous = elementData[index];
        elementData[index] = value;
        return previous;
    }

    @Override
    public String get(int index) {
        validateIndexRange(index);
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        return Arrays.asList(elementData).contains(value);
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elementData[i], value)) {
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
        int index = indexOf(value);
        if (index > -1) {
            fastRemove(index);
            return true;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        validateIndexRange(index);
        String oldValue = elementData[index];
        fastRemove(index);
        return oldValue;
    }

    private void fastRemove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
    }

    @Override
    public void clear() {
        elementData = EMPTY_ELEMENT_DATA;
        size = 0;
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index + 1 > size) {
            throw new IndexOutOfBoundsException("인덱스의 범위가 올바르지 않습니다. index: " + index);
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(elementData)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
