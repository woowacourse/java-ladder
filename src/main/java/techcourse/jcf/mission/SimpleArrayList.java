package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static final int MINIMUM_SIZE = 2;

    private int currentIndex = 0;
    private String[] list = new String[MINIMUM_SIZE];

    @Override
    public boolean add(final String value) {
        list[currentIndex++] = value;
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
