package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int INITIAL_SIZE = 0;
    private String[] elementData;
    private int size;

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        this.size = INITIAL_SIZE;
    }

    public void checkWrongIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("잘못된 인덱스 참조");
        }
    }

    @Override
    public boolean add(String value) {
        elementData = Arrays.copyOf(elementData, ++size);
        elementData[size - 1] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index != size) {
            checkWrongIndex(index);
        }
        String[] targetData = new String[++size];
        System.arraycopy(elementData, 0, targetData, 0, index);
        targetData[index] = value;
        System.arraycopy(elementData, index, targetData, index + 1, size - index - 1);
        elementData = targetData;
    }

    @Override
    public String set(int index, String value) {
        checkWrongIndex(index);
        String oldValue = elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkWrongIndex(index);
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        return Arrays.stream(elementData).anyMatch(element -> element.equals(value));
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index < 0) {
            return false;
        }

        String[] targetData = new String[--size];
        System.arraycopy(elementData, 0, targetData, 0, index);
        System.arraycopy(elementData, index + 1, targetData, index, size - index);
        elementData = targetData;
        return true;
    }

    @Override
    public String remove(int index) {
        checkWrongIndex(index);
        String oldValue = elementData[index];
        String[] targetData = new String[--size];
        System.arraycopy(elementData, 0, targetData, 0, index);
        System.arraycopy(elementData, index + 1, targetData, index, size - index);
        elementData = targetData;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
}
