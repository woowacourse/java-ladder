package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {
    private static final int DEFAULT_SIZE = 10;
    private String[] arrayList = new String[DEFAULT_SIZE];
    private int size = 0;

    @Override
    public boolean add(String value) {
        if (size == arrayList.length) {
            increaseSize();
        }
        arrayList[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndexRange(index);
        if (size == arrayList.length) {
            increaseSize();
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        validateIndexRange(index);
        String prevValue = arrayList[index];
        arrayList[index] = value;
        return prevValue;
    }

    @Override
    public String get(int index) {
        validateIndexRange(index);
        return arrayList[index];
    }

    @Override
    public boolean contains(String value) {
        for (String element : arrayList) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < size; index++) {
            if (arrayList[index].equals(value)) {
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
        int foundIndex = indexOf(value);
        if (foundIndex == -1) {
            return false;
        }
        System.arraycopy(arrayList, foundIndex + 1, arrayList, foundIndex, size - foundIndex - 1);
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndexRange(index);
        String value = arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
        size--;
        return value;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            arrayList[index] = null;
        }
        size = 0;
    }

    private void increaseSize() {
        String[] newArrayList = new String[size * 2];
        System.arraycopy(arrayList, 0, newArrayList, 0, size);
        arrayList = newArrayList;
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
