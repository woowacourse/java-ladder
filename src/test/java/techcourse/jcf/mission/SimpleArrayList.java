package techcourse.jcf.mission

public class SimpleArrayList implements SimpleList {
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int pointer;
    private final String[] values;

    public SimpleArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.values = new String[10];
    }

    public SimpleArrayList(String[] values) {
        this.capacity = DEFAULT_CAPACITY;
        this.values = values;
        manageCapacity();
    }

    private void manageCapacity() {
        if (values.length >= capacity * 0.8) {
            capacity *= 2;
        }
    }

    @Override
    public boolean add(String value) {

        return false;
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
        return true;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
