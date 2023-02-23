package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int pointer;
    private String[] values;

    public SimpleArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.values = new String[10];
    }

    public SimpleArrayList(String[] values) {
        this.capacity = DEFAULT_CAPACITY;
        this.values = values;
        this.pointer = values.length;
        checkCapacityUnderKeepingOrder();
        checkCapacityOverKeepingOrder();
    }

    private void checkCapacityUnderKeepingOrder() {
        if (this.values.length < 10) {
            String[] newValues = new String[DEFAULT_CAPACITY];
            for (int i = 0; i < this.values.length; i++) {
                newValues[i] = this.values[i];
            }
            this.values = newValues;
        }
    }

    private void checkCapacityOverKeepingOrder() {
        if (pointer >= capacity * 0.8) {
            copyValuesIntactly();
        }
    }

    private void copyValuesIntactly() {
        this.capacity *= 2;
        String[] newValues = new String[this.capacity];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    @Override
    public String get(int index) {
        return this.values[index];
    }

    @Override
    public boolean add(String value) {
        this.values[pointer] = value;
        this.pointer += 1;
        checkCapacityOverKeepingOrder();
        return true;
    }

    @Override
    public void add(int index, String value) {
        checkIndexWithInRange(index);
        for (int i = pointer; i > index; i--) {
            values[i] = values[i - 1];
        }
        this.values[index] = value;
        this.pointer += 1;
        checkCapacityOverKeepingOrder();
    }

    private void checkIndexWithInRange(int index) {
        if (index > this.pointer) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return true;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return "SimpleArrayList{" +
                "capacity=" + capacity +
                ", pointer=" + pointer +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
