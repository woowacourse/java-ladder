package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private int size;

    public SimpleLinkedList() {
        this.head = new Node();
        this.size = 0;
    }

    class Node {
        private Node next;
        private String value;


        public Node() {
            this.next = null;
            this.value = null;
        }

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }
    }

    @Override
    public boolean add(String value) {
        Node cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new Node(null, value);
        size++;

        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = head;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        prev.next = new Node(cur, value);
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node cur = head;

        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        String preValue = cur.value;
        cur.value = value;

        return preValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node cur = head;

        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.value;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(String value) {
        Node cur = head;

        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (cur.value.equals(value)) {
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

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        Node next = cur.next;

        prev.next = next;
        size--;
        return false;
    }

    @Override
    public String remove(int index) {
        Node prev = head;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        Node next = cur.next;
        prev.next = next;
        size--;

        return cur.value;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }
}
