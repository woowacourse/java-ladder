package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static final int MINIMUM_SIZE = 2;

    private int size = 0;
    private int currentIndex = 0;
    private String[] list;

    public SimpleArrayList() {
        list = new String[MINIMUM_SIZE];
    }

    public SimpleArrayList(int size) {
        list = new String[size];
        this.size = size;
    }

    //TODO: List의 크기가 자동으로 늘어나게 수정
    @Override
    public boolean add(final String value) {
        size += 1;
        list[currentIndex++] = value;
        return true;
    }

    //TODO: add한 index 뒤에 있는 값들을 전부 이동 시키기
    @Override
    public void add(final int index, final String value) {
        size += 1;
        list[index] = value;
    }

    @Override
    public String set(final int index, final String value) {
        final String previousValue = list[index];
        list[index] = value;
        return previousValue;
    }

    @Override
    public String get(final int index) {
        return list[index];
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
