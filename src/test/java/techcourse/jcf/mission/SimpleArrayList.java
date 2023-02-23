package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private int size;
    private int capacity = 10;
    private String[] array;

    public SimpleArrayList() {
        this.array = new String[capacity];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        array = resize();
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array = resize();
        size++;
        String[] temp = new String[capacity];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        temp[index] = value;
        for (int i = index + 1; i < size; i++) {
            temp[i] = array[i - 1];
        }
        array = temp;
    }

    @Override
    public String set(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        String temp = array[index];
        array[index] = value;
        return temp;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
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
        String[] temp = new String[capacity];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            temp[j++] = array[i];
        }
        array = temp;
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        int j = 0;
        String[] temp = new String[capacity];
        String removed = "";
        for (int i = 0; i < size; i++) {
            if (i == index) {
                removed = array[index];
                continue;
            }
            temp[j++] = array[i];
        }
        size--;
        array = temp;
        return removed;
    }

    @Override
    public void clear() {
        array = new String[10];
        size = 0;
    }

    private String[] resize() {
        if (array.length < size + 1){
            String[] temp = array;
            capacity *= 2;
            this.array = new String[capacity];
            for (int i = 0; i < size; i++) {
                array[i] = temp[i];
            }
        }
        return array;
    }
}