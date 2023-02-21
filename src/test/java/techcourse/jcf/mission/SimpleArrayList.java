package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    String[] strings;
    int pointer;
    int capacity;

    public SimpleArrayList() {
        capacity = 2;
        strings = new String[capacity];
        pointer = 0;
    }

    public void resize() {
        capacity = capacity * 2;
        String[] tmp = new String[capacity];
        copy(strings, tmp);
        strings = new String[capacity];
        copy(tmp, strings);
    }

    private void copy(String[] src, String[] des) {
        for (int i = 0; i < strings.length; i++) {
            des[i] = src[i];
        }
    }

    private boolean isFull() {
        return capacity == pointer;
    }

    @Override
    public boolean add(String value) {
        if (isFull()) {
            resize();
        }
        strings[pointer++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (isFull()) {
            resize();
        }
        for (int i = pointer; i > index; i--) {
            strings[i] = strings[i - 1];
        }
        strings[index] = value;
        ++pointer;
    }

    @Override
    public String set(int index, String value) {
        strings[index] = value;
        return value;
    }

    @Override
    public String get(int index) {
        return strings[index];
    }

    @Override
    public boolean contains(String value) {
        return Arrays.stream(strings)
                .anyMatch(s -> s != null && s.equals(value));
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == value) {
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
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == value) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        String string = strings[index];
        for (int i = index; i < pointer; i++) {
            strings[i] = strings[i + 1];
        }
        --pointer;
        return string;
    }

    @Override
    public void clear() {
        pointer = 0;
        strings = new String[capacity];
    }

    public void print() {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
