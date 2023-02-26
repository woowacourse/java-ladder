package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private String[] values;
    private int size;


    public SimpleArrayList(int initSize) {
        this.values = new String[initSize];
        this.size = 0;
    }

    public SimpleArrayList() {
        this(10);
    }

    @Override
    public boolean add(String value) {
        try {
            add(this.size, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void add(int index, String value) {
        if (!(index<=this.size)){
            throw new IllegalArgumentException("원소를 추가할 위치는 현재 리스트 크기 이하여야 합니다.");
        }
        for (int i = this.size; i >index; i--) {
            values[i] = values[i-1];
        }
        values[index] = value;
        ++this.size;
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
