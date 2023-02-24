package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {

    private static final int INITIAL_CAPACITY = 10;

    private String[] list;
    private int currentIndex;
    private int capacity;

    public SimpleArrayList() {
        currentIndex = 0;
        capacity = INITIAL_CAPACITY;
        list = new String[capacity];
    }

    @Override
    public boolean add(String value) {
        if (list.length >= capacity) {
            capacity += INITIAL_CAPACITY;
            String[] newList = new String[capacity];

            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }

            list = newList;
        }
        list[currentIndex++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index > currentIndex) {
            throw new IndexOutOfBoundsException("추가하려는 위치는 0부터 리스트의 크기까지 가능합니다.");
        }

        if (index >= capacity) {
            capacity += INITIAL_CAPACITY;
        }

        String[] newList = new String[capacity];

        for (int i = 0; i < index; i++) {
            newList[i] = list[i];
        }

        for (int i = index; i < list.length; i++) {
            newList[i + 1] = list[i];
        }

        newList[index] = value;
        list = newList;
    }

    @Override
    public String set(int index, String value) {
        if (index >= currentIndex) {
            throw new IndexOutOfBoundsException("수정할 위치는 0부터 리스트의 크기-1까지 가능합니다.");
        }

        String before = list[index];
        list[index] = value;
        return before;
    }

    @Override
    public String get(int index) {
        if (index >= currentIndex) {
            throw new IndexOutOfBoundsException("가져올 위치는 0부터 리스트의 크기-1까지 가능합니다.");
        }
        return list[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < currentIndex; i++) {
            if (list[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < currentIndex; i++) {
            if (list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean remove(String value) {
        int removeIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (list[i].equals(value)) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex == -1) {
            return false;
        }
        for (int i = removeIndex; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        currentIndex--;
        return true;
    }

    @Override
    public String remove(int index) {
        if (index >= currentIndex) {
            throw new IndexOutOfBoundsException("삭제할 위치는 0부터 리스트의 크기-1까지 가능합니다.");
        }

        String removed = list[index];

        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        currentIndex--;

        return removed;
    }

    @Override
    public void clear() {
        capacity = INITIAL_CAPACITY;
        list = new String[capacity];
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < currentIndex - 1; i++) {
            result += list[i] + ", ";
        }
        result += list[currentIndex - 1] + "]";

        return result;
    }
}
