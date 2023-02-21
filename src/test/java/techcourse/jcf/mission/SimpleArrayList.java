package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private String[] arr;
    private int capacity;
    private int size;

    public SimpleArrayList() {
        this.capacity = 1;
        this.size = 0;
        this.arr = new String[capacity];
    }

    @Override
    public boolean add(String value) {
        expandArr();

        arr[size] = value;
        size += 1;
        return true;
    }

    private void expandArr() {
        if (isFull()) {
            capacity *= 2;
            arr = createdExpandedArr();
        }
    }

    private boolean isFull() {
        return size == capacity;
    }

    private String[] createdExpandedArr() {
        String[] newArr = new String[capacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    @Override
    public void add(int index, String value) {
        validateIndex(index);
        expandArr();
        for (int i = size; i < index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size += 1;
    }

    private void validateIndex(int index) {
        if (index > size) {
            String message = String.format("Index : %d , Size : %d", index, size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public String set(int index, String value) {
        String oldValue = arr[index];
        arr[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        return arr[index];
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
