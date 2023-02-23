package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {
    private static int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private int capacity;
    private String[] elements;

    public SimpleArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new String[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("초기 캐패시티는 양수여야 합니다.");
        }
        this.capacity = initialCapacity;
        this.elements = new String[initialCapacity];
    }

    @Override
    public boolean add(String value) {
        if (size < capacity) {
            elements[size] = value;
        } else {
            // cpp clang 따라하기 (capacity 2배)
            capacity <<= 2;
            String[] newElements = new String[capacity];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            newElements[size] = value;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0) {
            throw new IllegalArgumentException("잘못된 index 입력입니다");
        }



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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
