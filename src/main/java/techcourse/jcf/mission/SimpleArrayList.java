package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private String[] array;
    private int size;
    private int capacity;

    public SimpleArrayList() {
        this.size = 0;
        this.capacity = 5;
        this.array = new String[capacity];
    }

    private void expand(int capacity) {
        String[] previous = this.array;
        this.capacity = capacity * 2;
        this.array = new String[capacity];
        for (int i = 0; i < this.size; i++) {
            array[i] = previous[i];
        }
    }

    @Override
    public boolean add(String value) {
        if (size >= capacity - 5) {
            expand(capacity);
        }
        array[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index >= size) {
            for (int i = size; i < index; i++) {
                add(null);
            }
            add(value);
        } else {
            size++;
            if (size >= capacity) {
                expand(capacity);
            }
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            set(index, value);
        }
    }

    @Override
    public String set(int index, String value) {
        String previous = array[index];
        array[index] = value;
        return previous;
    }

    @Override
    public String get(int index) {
        if (index < size) {
            return array[index];
        }
        return null;
    }

    @Override
    public boolean contains(String value) {
        if (indexOf(value) == -1)
            return false;
        return true;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        if (indexOf(value) == -1)
            return false;
        remove(indexOf(value));
        return true;
    }

    @Override
    public String remove(int index) {
        if (size <= 0)
            return null;

        String removed = array[index];
        array[index] = null;
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.capacity = 5;
        this.array = new String[capacity];
    }
}
