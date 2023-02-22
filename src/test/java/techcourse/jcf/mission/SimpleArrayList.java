package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    public static final int DEFAULT_SIZE = 0;
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private String[] elementData;
    private int size;

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        this.size = DEFAULT_SIZE;
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
            checkIndex(index);
        }
        String[] target = new String[++size];
        System.arraycopy(elementData, 0, target, 0, index);
        target[index] = value;
        System.arraycopy(elementData, index, target, index + 1, size - index - 1);
        elementData = target;
    }

    @Override
    public String set(int index, String value) {
        checkIndex(index);
        String oldValue = elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
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
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(value)) {
                return index;
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
        if (index == 1) {
            return false;
        }
        removeData(index);
        return true;
    }

    private void removeData(int index) {
        String[] target = new String[--size];
        System.arraycopy(elementData, 0, target, 0, index);
        System.arraycopy(elementData, index + 1, target, index, size - index);
        elementData = target;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String oldData = elementData[index];
        removeData(index);
        return oldData;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            elementData[index] = null;
        }
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
