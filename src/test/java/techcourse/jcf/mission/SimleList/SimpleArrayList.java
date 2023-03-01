package techcourse.jcf.mission.SimleList;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int DefaultSize = 8;
    private String[] data = new String[DefaultSize];
    private int size = 0;

    @Override
    public boolean add(final String value) {
        try {
            checkDataSize();
            data[size] = value;
            size++;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void add(final int index, final String value) {
        try {
            checkDataSize();
            checkIndex(index);
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = value;
            size++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkIndex(final int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("해당 index는 배열의 크기를 넘습니다.");
        }
    }

    @Override
    public String set(final int index, final String value) {
        checkIndex(index);
        data[index] = value;
        return data[index];
    }

    @Override
    public String get(final int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean contains(final String value) {
        if (indexOf(value) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(final String value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
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
        return size == 0 ? true : false;
    }

    @Override
    public boolean remove(final String value) {
        final int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String remove(final int index) {
        checkIndex(index);
        String deletedData = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return deletedData;
    }

    @Override
    public void clear() {
        size = 0;
        data = new String[8];
    }

    private void checkDataSize() {
        if (data.length == size) {
            String[] newData = Arrays.copyOf(data, data.length + 8);
            data = newData;
        }
    }
}
