package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node start;
    private int size;

    public SimpleLinkedList() {
        this.start = new Node(null, null);
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node newNode = new Node(value, null);
        Node tmp = start;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node newNode = new Node(value, null);
        Node tmp = start;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node tmp = start.next;
        String result;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        result = tmp.data;
        tmp.data = value;
        return result;
    }

    @Override
    public String get(int index) {
        Node tmp = start.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    @Override
    public boolean contains(String value) {
        Node tmp = start.next;
        while (tmp.next != null) {
            if (tmp.data.equals(value)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        Node result = start;
        while (result.next != null) {
            if (result.data.equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        remove(indexOf(value));
        return true;
    }

    @Override
    public String remove(int index) {
        Node tmp = start;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        String result = tmp.next.data;
        Node nextNode = tmp.next;
        tmp.next = nextNode.next;
        nextNode = null;
        size--;
        return result;
    }

    @Override
    public void clear() {
        Node result = start;
        while (result.next != null) {
            Node tmp = result;
            result = result.next;
            tmp = null;
        }
        start = null;
        this.start = new Node(null, null);
        size = 0;
    }
}
