package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_UP_SIZE = 5;

    private String[] array;
    private int upSize = DEFAULT_UP_SIZE;
    private int index = 0;

    public SimpleArrayList() {
        this.array = new String[DEFAULT_SIZE];
        this.upSize = DEFAULT_UP_SIZE;
    }

    public SimpleArrayList(int size) {
        int bigSize = calculateBigSize(size);

        this.array = new String[bigSize];
    }

    public SimpleArrayList(int size, int upSize) {
        int bigSize = calculateBigSize(size);

        this.array = new String[bigSize];
        this.upSize = calculateBigUpSize(upSize);
    }

    private int calculateBigSize(int size) {
        return Math.max(size, DEFAULT_SIZE);
    }

    private int calculateBigUpSize(int upSize) {
        return Math.max(upSize, this.upSize);
    }

    @Override
    public boolean add(String value) {
        if (index == array.length - 1) {
            cloneArrayForSizeUp();
        }
        array[index++] = value;
        return true;
    }

    private void cloneArrayForSizeUp() {
        String[] newArray = new String[array.length + upSize];

        System.arraycopy(array, 0, newArray, 0, array.length);
        deleteArray(array);
        this.array = newArray;
    }

    private void deleteArray(String[] target) {
        Arrays.stream(target).forEach(element -> element = null);
    }

    @Override
    public void add(int index, String value) {
        if (index == array.length) {
            cloneArrayForSizeUp();
        }
        insertMiddle(index, value);
        this.index++;
    }

    private void insertMiddle(int index, String value) {
        for (int i = this.index - 1; i > index - 1; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
    }

    @Override
    public String set(int index, String value) {
        String temp = array[index];

        array[index] = value;
        return temp;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < index; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        return IntStream.rangeClosed(0, index)
                .filter(i -> value.equals(array[i]))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean remove(String value) {
        int removeIndex = indexOf(value);

        if (removeIndex == -1) {
            return false;
        }
        processRemoveArrayElement(removeIndex);
        return true;
    }

    private void processRemoveArrayElement(int removeIndex) {
        for (int i = removeIndex; i < index; i++) {
            array[i] = array[i + 1];
        }
        index--;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String temp = array[index];

        for (int i = index; i < this.index; i++) {
            array[i] = array[i + 1];
        }
        this.index--;
        return temp;
    }

    private void validateIndex(int index) {
        if (index <= -1 || index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        deleteArray(array);
        this.index = 0;
    }
}
