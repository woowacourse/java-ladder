package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private String[] arrayList = new String[10];
    private int size = 0;

    @Override
    public boolean add(String value) {
        if (size == arrayList.length) {
            String[] newArrayList = new String[size * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, size);
            arrayList = newArrayList;
        }

        arrayList[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException();
        }
        if (size == arrayList.length) {
            String[] newArrayList = new String[size * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, size);
            arrayList = newArrayList;
        }

        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException();
        }
        String oldElement = arrayList[index];
        arrayList[index] = value;
        return oldElement;
    }

    @Override
    public String get(int index) {
        if (index < size) {
            return arrayList[index];
        }
        throw new RuntimeException();
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
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(value)) {
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
        if (index != -1) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
            size--;
            return true;
        }

        return false;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException();
        }

        String removeElement = arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
        size--;
        return removeElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }
}
