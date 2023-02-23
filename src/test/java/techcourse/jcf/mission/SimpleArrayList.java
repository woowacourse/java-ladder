package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static final String[] SIMPLE_ARRAY = {};
    private static final int INITIAL_CAPACITY = 10;

    private int size;
    private final String[] array;

    public SimpleArrayList() {
        this.array = SIMPLE_ARRAY;
        this.size = INITIAL_CAPACITY;
    }

    @Override
    public boolean add(final String value) {
        return true;
    }

    @Override
    public void add(final int index, final String value) {

    }

    @Override
    public String set(final int index, final String value) {
        return null;
    }

    @Override
    public String get(final int index) {
        return null;
    }

    @Override
    public boolean contains(final String value) {
        return false;
    }

    @Override
    public int indexOf(final String value) {
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
    public boolean remove(final String value) {
        return false;
    }

    @Override
    public String remove(final int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
