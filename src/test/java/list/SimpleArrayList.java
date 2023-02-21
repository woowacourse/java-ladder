package list;

public class SimpleArrayList implements SimpleList {

    private static final int INITIAL_CAPACITY = 1;
    private static final int INITIAL_SIZE = 0;

    private int capacity;
    private int size;
    private String[] data;

    public SimpleArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.size = INITIAL_SIZE;
        this.data = new String[capacity];
    }

    @Override
    public boolean add(String value) {
        if (capacity == size) {
            expandCapacity();
        }
        data[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
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
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void expandCapacity() {
        capacity *= 2;
        String[] newData = new String[capacity];
        copyArray(newData, data);
        data = newData;
    }

    private void copyArray(String[] newData, String[] oldData) {
        for (int i = 0; i < oldData.length; i++) {
            newData[i] = oldData[i];
        }
    }
}
