package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;
    private int currentIndex = 0;
    private String[] values;

    public SimpleArrayList() {
        values = new String[DEFAULT_SIZE];
    }

    public SimpleArrayList(final String[] values) {
        this.size = values.length;
        this.values = values;
    }

    //TODO: List의 크기가 자동으로 늘어나게 수정
    @Override
    public boolean add(final String value) {
        size += 1;
        values[currentIndex++] = value;
        return true;
    }

    //TODO: add한 index 뒤에 있는 값들을 전부 이동 시키기
    @Override
    public void add(final int index, final String value) {
        size += 1;
        values[index] = value;
    }

    @Override
    public String set(final int index, final String value) {
        final String previousValue = values[index];
        values[index] = value;
        return previousValue;
    }

    @Override
    public String get(final int index) {
        return values[index];
    }

    @Override
    public boolean contains(final String value) {
        for (String storedValue : values) {
            if (storedValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final String value) {
        for (int index = 0; index < size; index++) {
            if (values[index].equals(value)) {
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
        return false;
    }

    @Override
    public boolean remove(final String value) {
        return false;
    }

    @Override
    public String remove(final int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return "SimpleArrayList{" +
                "size=" + size +
                ", currentIndex=" + currentIndex +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
