package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final String[] DEFAULT_CAPACITY = {};

    private String[] elementData;

    private int size;

    public SimpleArrayList() {
        this.elementData = DEFAULT_CAPACITY;
        this.size = 0;
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
        String[] targetArray = new String[++size];
        System.arraycopy(elementData, 0, targetArray, 0, index);
        targetArray[index] = value;
        System.arraycopy(elementData, index, targetArray, index + 1, size - index - 1);
        elementData = targetArray;

    }

    private void checkWrongIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("잘못된 인덱스 참조");
        }
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
        for (String data : elementData) {
            if (data.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Integer i = findFirstValueIndex(value);
        if (i != null) {
            return i;
        }
        return -1;
    }

    private Integer findFirstValueIndex(String value) {
        for (int i = 0; i <= size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return null;
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
        if (index == -1) {
            return false;
        }
        removeElement(index);
        return true;
    }

    private void removeElement(int index) {
        String[] targetArray = new String[--size];
        System.arraycopy(elementData, 0, targetArray, 0, index);
        System.arraycopy(elementData, index + 1, targetArray, index, size - index);
        elementData = targetArray;
    }

    @Override
    public String remove(int index) {
        checkWrongIndex(index);
        String oldValue = elementData[index];
        removeElement(index);
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        this.size = 0;
    }
}
