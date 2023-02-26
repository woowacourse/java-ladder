package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;

    private String[] data;

    public SimpleArrayList(int firstCapacity) {
        if (firstCapacity > 0) {
            data = new String[firstCapacity];
        } else if (firstCapacity == 0) {
            data = new String[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Invalid Capacity");
        }
    }

    public SimpleArrayList() {
        data = new String[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        resize();
        data[size++] = value;
        return true;
    }

    private void resize() {
        if (size == data.length - 1) {
            String[] clone = data.clone();

            int length = data.length;
            data = new String[length * 2];
            for (int index = 0; index < length; index++) {
                data[index] = clone[index];
            }
        }
    }

    @Override
    public void add(int index, String value) {
        resize();
        int length = size - index;
        String[] clone = new String[length];

        for (int i = index; i < index + length; i++) {
            clone[i - index] = data[i];
        }

        data[index] = value;
        for (int i = index + 1; i < index + 1 + clone.length ; i++) {
            data[i] = clone[i - (index + 1)];
        }
        size++;
    }

    @Override
    public String set(int index, String value) {
        String oldValue = data[index];
        data[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        return data[index];
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < size; index++) {
            if (data[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < size; index++) {
            if (data[index].equals(value)) {
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
        int index = -1;

        for (int dataIndex = 0; dataIndex < size; dataIndex++) {
            if (data[dataIndex].equals(value)) {
                index = dataIndex;
            }
        }
        if (index == -1) {
            return false;
        }
        moveForward(index);
        return true;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Invalid Index");
        }
        String oldValue = data[index];
        moveForward(index);
        return oldValue;
    }

    private void moveForward(int index) {
        if (size != 1) {
            String front;
            String back = data[size - 1];
            for (int backIndex = size - 1; backIndex > index; backIndex--) {
                front = data[backIndex - 1];
                data[backIndex - 1] = back;
                back = front;
            }
        }
        data[size - 1] = null;
        size--;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            data[index] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int index = 0; index < size; index++) {
            stringBuilder.append(data[index]);
            if (index != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
