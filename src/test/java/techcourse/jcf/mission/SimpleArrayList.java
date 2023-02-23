package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    private static final String[] EMPTY_ELEMENTDATA = {};
    private String[] elementData = {};
    private int size = 0;


    @Override
    public boolean add(String value) {
        grow(size + 1);
        elementData[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateOutOfIndex(index);
        if (size == this.elementData.length)
            elementData = grow(size + 1);

        System.arraycopy(elementData, index,
                elementData, index + 1,
                size - index);
        elementData[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        validateOutOfIndex(index);
        elementData[index] = value;
        return elementData[index];
    }

    @Override
    public String get(int index) {
        validateOutOfIndex(index);
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        throw new IllegalArgumentException("리스트 내에 존재하지 않는 요소입니다.");
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
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(value)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        validateOutOfIndex(index);
        final String[] tmp = elementData;

        String oldValue = tmp[index];

        final int newSize = size - 1;
        if ((newSize) > index)
            System.arraycopy(tmp, index + 1, tmp, index, newSize - index);

        //마지막 index
        tmp[size - 1] = null;
        size--;

        elementData = tmp;
        return oldValue;
    }

    @Override
    public void clear() {
        elementData = EMPTY_ELEMENTDATA;
        size = 0;
    }

    private String[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); //약 old * 1.5
        if (newCapacity - minCapacity <= 0) {
            if (elementData == EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    private void validateOutOfIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("범위 밖의 인덱스 입니다.");
        }
    }
}
