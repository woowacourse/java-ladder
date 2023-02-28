package techocourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENT = {};

    private Object[] elements;
    private int size;

    public SimpleArrayList() {
        elements = EMPTY_ELEMENT;
        this.size = 0;
    }

    public SimpleArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("배열의 크기는 음수가 될 수 없습니다.");
        }
        this.elements = new Object[size];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if (size == 0 || size == elements.length) {
            resize();
        }
        elements[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        checkIndex(index);

        if (index == size) {
            add(value);
            return;
        }

        if (size == elements.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        checkIndex(index);
        elements[index] = value;
        return value;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return (String) elements[index];
    }

    @Override
    public boolean contains(String value) {
        return indexOfRange(value, 0, size) >= 0;
    }

    @Override
    public int indexOf(String value) {
        return indexOfRange(value, 0, size);
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
        int removeIndex = indexOfRange(value, 0, size);

        if (removeIndex == -1) {
            return false;
        }

        remove(removeIndex);
        return true;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);

        String oldValue = (String) elements[index];
        elements[index] = null;

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
            elements[i+1] = null;
        }
        size--;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void resize() {
        int capacity = elements.length;

        if (size == 0) {
            elements = new Object[DEFAULT_CAPACITY];
            return;
        }

        if (size == capacity) {
            int new_capacity = capacity * 2;
            elements = Arrays.copyOf(elements, new_capacity);
            return;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("인덱스 범위를 확인하세요");
        }
    }

    private int indexOfRange(Object o, int start, int end) {
        Object[] es = elements;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
