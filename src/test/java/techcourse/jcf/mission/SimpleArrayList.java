package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList{

    private final int initCapacity;
    private int capacity;
    private int tailIndex;
    private String[] storage;

    public SimpleArrayList() {
        this(10);
    }

    public SimpleArrayList(int capacity) {
        this.initCapacity = capacity;
        this.capacity = capacity;
        this.tailIndex = -1;
        this.storage = new String[this.capacity];
    }

    @Override
    public boolean add(String value) {
        if (storage.length - 1 == tailIndex) {
            capacity *= 1.5;
            storage = Arrays.copyOf(storage, capacity);
        }
        tailIndex += 1;
        this.storage[tailIndex] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        checkOutOfIndex(index);
        add(value);
        for (int i = tailIndex - 1; i >= index ; i--) {
            storage[i+1] = storage[i];
        }
        storage[index] = value;
    }

    @Override
    public String set(int index, String value) {
        checkOutOfIndex(index);
        String oldValue = storage[index];
        storage[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkOutOfIndex(index);
        return storage[index];
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < tailIndex + 1; index++) {
            if(storage[index].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < tailIndex + 1; index++) {
            if(storage[index].equals(value)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return tailIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        if (tailIndex == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        for (int index = 0; index < tailIndex; index++) {
            if(storage[index].equals(value)){
                remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkOutOfIndex(index);
        String oldValue = storage[index];
        for (int i = index + 1; i < tailIndex + 1; i++) {
            storage[i] = storage[i-1];
        }
        tailIndex -= 1;
        return oldValue;
    }

    @Override
    public void clear() {
        capacity = initCapacity;
        tailIndex = -1;
        storage = new String[initCapacity];
    }

    private void checkOutOfIndex(int index) {
        if (index >= capacity) {
            throw new IllegalArgumentException("[ERROR] 인덱스 벗어남");
        }
    }

}
