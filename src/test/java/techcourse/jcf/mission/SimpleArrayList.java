package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;

    private static final String[] EMPTY_ELEMENTDATA = {};
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private String[] elementData;
    private int modCount = 0;
    private int size = 0;

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new String[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(String value) {
        modCount++;
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size++] = value;
        return true;
    }

    private String[] grow() {
        return Arrays.copyOf(elementData, size + 1);
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
