package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int BASIC_ARRAY_SIZE = 10;
    private String[] values;
    private int size;

    public SimpleArrayList() {
        this.values = new String[BASIC_ARRAY_SIZE];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if (size >= values.length) {
            makeArraySizeDouble();
        }
        values[size++] = value;
        return true;
    }

    private void makeArraySizeDouble() {
        String[] result = new String[this.values.length * 2];
        System.arraycopy(this.values, 0, result, 0, this.values.length);
        this.values = result;
    }

    @Override
    public void add(int index, String value) {
        if (isIndexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException("인덱스는 배열의 크기보다 작아야 합니다.");
        }
        String[] tempValues = Arrays.copyOfRange(values, index, values.length);
        System.arraycopy(tempValues, 0, values, index + 1, tempValues.length);
        values[index] = value;
        size++;
    }

    private boolean isIndexOutOfRange(int index) {
        return index >= size;
    }

    @Override
    public String set(int index, String value) {
        if (isIndexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException("인덱스는 배열의 크기보다 작아야 합니다.");
        }
        String oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (isIndexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException("인덱스는 배열의 크기보다 작아야 합니다.");
        }
        return values[index];
    }

    @Override
    public boolean contains(String value) {
        for (String arrayListValue : values) {
            if (arrayListValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < values.length; i++) {
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
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        if (!contains(value)) {
            throw new IllegalStateException("배열에 존재하지 않는 값입니다.");
        }
        remove(indexOf(value));
        return true;
    }

    @Override
    public String remove(int index) {
        if (isIndexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException("인덱스는 배열의 크기보다 작아야 합니다.");
        }
        String oldValue = values[index];
        String[] tempValues = Arrays.copyOfRange(values, index + 1, values.length);
        System.arraycopy(tempValues, 0, values, index, tempValues.length);
        size--;
        return oldValue;
    }

    @Override
    public void clear() {
        values = new String[0];
        size = 0;
    }
}
