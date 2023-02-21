package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private String[] arrayList = new String[2];
    private int size = 0;

    @Override
    public boolean add(String value) {
        if (size >= arrayList.length) {
            String[] newArrayList = new String[arrayList.length * 2];

            for (int i = 0; i < arrayList.length; i++) {
                newArrayList[i] = arrayList[i];
            }
            arrayList = newArrayList;
        }
        arrayList[size] = value;
        size++;

        return true;
    }

    @Override
    public void add(int index, String value) {
        if (size == arrayList.length) {
            String[] newArrayList = new String[arrayList.length * 2];

            for (int i = 0; i < arrayList.length; i++) {
                newArrayList[i] = arrayList[i];
            }
            arrayList = newArrayList;
        }

        for (int i = size; i > index; i--) {
            arrayList[size] = arrayList[size - 1];
        }
        arrayList[index] = value;
    }

    @Override
    public String set(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        String oldValue = value;
        arrayList[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return arrayList[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(value)) {
                return i;
            }
        }
        throw new Exception();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {

        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(value)) {
                int index = i;
                for (int j = index; j < size; j++) {
                    arrayList[j] = arrayList[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        String oldString = arrayList[index];
        for (int j = index; j < size; j++) {
            arrayList[j] = arrayList[j + 1];
        }
        size--;
        return oldString;
    }

    @Override
    public void clear() {
        arrayList = new String[2];
        size = 0;
    }
}
