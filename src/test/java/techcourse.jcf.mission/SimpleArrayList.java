package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {
    private static final int INITIAL_CAPACITY = 10;
    private String[] values;

    public SimpleArrayList() {
        this.values = new String[INITIAL_CAPACITY];
    }

    @Override
    public boolean add(String value) {
        int currentCapacity = values.length;
        int currentSize = 0;
        for (String element : values) {
            if (element != null) {
                currentSize++;
            }
        }
        if (currentSize >= currentCapacity) {
            String[] currentValues = this.values;
            values = new String[currentCapacity * 2];
            for (int index = 0; index < values.length; index++) {
                values[index] = currentValues[index];
            }
            values[currentSize] = value;
            return true;
        }
        values[currentSize] = value;
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
}
