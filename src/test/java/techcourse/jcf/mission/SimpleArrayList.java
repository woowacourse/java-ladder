package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimpleArrayList implements SimpleList {

    private String[] array;
    private int pointer;

    public SimpleArrayList() {
        array = new String[1];
        pointer = 0;
    }

    private void extendSize() {
        if (pointer == array.length) {
            String[] copyArray = array.clone();
            array = new String[array.length * 2];
            System.arraycopy(copyArray, 0, array, 0, array.length / 2);
        }
    }

    @Override
    public boolean add(String value) {
        array[pointer++] = value;
        extendSize();
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);
        for (int i = pointer - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = value;
        pointer++;
        extendSize();
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        String indexValue = array[index];
        array[index] = value;
        return indexValue;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public boolean remove(String value) {
        int targetIndex = -1;

        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(value)) {
                targetIndex = i;
            }
        }

        if (targetIndex == -1) {
            return false;
        }

        for (int i = targetIndex + 1; i < pointer; i++) {
            array[i - 1] = array[i];
        }

        array[--pointer] = null;
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String removeValue = array[index];

        for (int i = index + 1; i < pointer; i++) {
            array[i - 1] = array[i];
        }

        array[--pointer] = null;
        return removeValue;
    }

    private void validateIndex(int index) {
        if (!(0 <= index && index < pointer)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        array = new String[1];
        pointer = 0;
    }

    @Override
    public String toString() {
        return String.format("[%s]", Arrays.stream(array)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ")));
    }
}
