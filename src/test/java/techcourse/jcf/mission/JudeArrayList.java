package techcourse.jcf.mission;

public class JudeArrayList implements SimpleList {

    private int size;
    private int realSize = 10;
    private String[] array;

    public JudeArrayList() {
        this.array = new String[realSize];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        array = resizeArray();
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array = resizeArray();
        size++;
        String[] tmp = new String[realSize];
        for (int i = 0; i < index; i++) {
            tmp[i] = array[i];
        }
        tmp[index] = value;
        for (int i = index + 1; i < size; i++) {
            tmp[i] = array[i - 1];
        }

        array = tmp;

    }

    @Override
    public String set(int index, String value) {
        String prev = array[index];
        array[index] = value;
        return prev;
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
        String[] tmp = new String[realSize];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            tmp[j++] = array[i];
        }
        array = tmp;
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        int j = 0;
        String[] tmp = new String[realSize];
        String removed = "";
        for (int i = 0; i < size; i++) {
            if (i == index) {
                removed = array[index];
                continue;
            }
            tmp[j++] = array[i];
        }
        size--;
        array = tmp;
        return removed;
    }

    @Override
    public void clear() {
        array = new String[10];
        size = 0;
    }

    private String[] resizeArray() {
        if (size + 1 > array.length) {
            String[] tmp = array;
            realSize *= 2;
            this.array = new String[realSize];
            for (int i = 0; i < size; i++) {
                array[i] = tmp[i];
            }
        }
        return array;
    }
}
