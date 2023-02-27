package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private final Node head;
    private int size = 0;

    public SimpleLinkedList() {
        this.head = new Node();
    }

    class Node {
        private Node next;
        private String value;

        Node() {
            this.next = null;
            this.value = null;
        }

        Node(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public boolean add(String value) {
        Node nextNode = head;

        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }

        nextNode.next = new Node(value);
        size++;

        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        Node prevNode = head;

        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        Node nowNode = prevNode.next;
        Node newNode = new Node(value);
        prevNode.next = newNode;
        newNode.next = nowNode;
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        Node nowNode = head;
        for (int i = 0; i <= index; i++) {
            nowNode = nowNode.next;
        }
        String oldValue = nowNode.value;
        nowNode.value = value;

        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        Node nowNode = head;
        for (int i = 0; i <= index; i++) {
            nowNode = nowNode.next;
        }
        return nowNode.value;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(String value) {
        Node nowNode = head;

        for (int i = 0; i <= size; i++) {
            nowNode = nowNode.next;
            if (nowNode.value.equals(value)) {
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
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        Node nowNode = head;
        for (int i = 0; i < index; i++) {
            nowNode = nowNode.next;
        }

        nowNode.next = nowNode.next.next;
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        Node nowNode = head;
        for (int i = 0; i < index; i++) {
            nowNode = nowNode.next;
        }

        String removeValue = nowNode.next.value;
        nowNode.next = nowNode.next.next;
        size--;

        return removeValue;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }
}
