package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static int DEFAULT_CAPACITY = 10;

    private String[] values;
    private int size;

    public SimpleArrayList() {
        this.values = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if (size >= values.length) {
            values = increaseCapacity();
        }
        values[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size >= values.length) {
            values = increaseCapacity();
        }

        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = value;
        size++;
    }

    private String[] increaseCapacity() {
        String[] newArray = new String[values.length * 2];
        System.arraycopy(values, 0, newArray, 0, values.length);
        return newArray;
    }

    @Override
    public String set(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        String returnValue = values[index];
        values[index] = value;
        return returnValue;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
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
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        String returnValue = values[index];
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return returnValue;
    }

    @Override
    public void clear() {
        values = new String[DEFAULT_CAPACITY];
        size = 0;
    }

}
