package techcourse.jcf.mission;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Optional;

public class SimpleArrayList implements SimpleList {
    private static final int DEFAULT_SIZE = 200;

    private transient int currentIndex;
    private int size = DEFAULT_SIZE;
    private String[] lists;

    public SimpleArrayList() {
        this.lists = new String[DEFAULT_SIZE];
    }

    @Override
    public boolean add(String value) {
        if (checkArrayFull()) {
            lists = allocateNewArraySize();
        }

        lists[currentIndex++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (checkArrayFull()) {
            lists = allocateNewArraySize();
        }
        pushOneSpaceBefore(index);
        lists[index] = value;
    }

    @Override
    public String set(int index, String value) {
        validateOutOfRange(index);
        lists[index] = value;
        return value;
    }

    @Override
    public String get(int index) {
        validateOutOfRange(index);
        return lists[index];
    }

    @Override
    public boolean contains(String value) {
        return Arrays.asList(lists).contains(value);
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < currentIndex; index++) {
            if (lists[index].equals(value)) {
                return index;
            }
        }
        throw new NullPointerException("존재하지 않는 값입니다.");
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean remove(String value) {
        for (int index = 0; index < currentIndex; index++) {
            if (lists[index].equals(value)) {
                pullOneSpaceAfter(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        validateOutOfRange(index);
        validateNotExists(lists[index]);
        final String removedValue = lists[index];
        pullOneSpaceAfter(index);

        return removedValue;
    }

    @Override
    public void clear() {
        currentIndex = 0;
        lists = new String[DEFAULT_SIZE];
    }

    private String[] allocateNewArraySize() {
        size *= 1.5;
        return Arrays.copyOf(lists, size);
    }

    private boolean checkArrayFull() {
        return currentIndex + 1 == size;
    }

    private void pullOneSpaceAfter(int index) {
        for (int findIndex = index; findIndex < currentIndex; findIndex++) {
            lists[findIndex] = lists[findIndex + 1];
        }
    }

    private void pushOneSpaceBefore(int index) {
        for (int lastIndex = currentIndex++; lastIndex > index; lastIndex--) {
            lists[lastIndex + 1] = lists[lastIndex];
        }
    }

    private void validateOutOfRange(int index) {
        if (0 > index || index >= currentIndex) {
            throw new IndexOutOfBoundsException(MessageFormat.format("{0} 는 범위를 벗어난 인덱스입니다.", index));
        }
    }

    private <T> void validateNotExists(T t) {
        Optional.ofNullable(t).orElseThrow(() -> new NullPointerException("존재하지 않는 값입니다."));
    }
}
