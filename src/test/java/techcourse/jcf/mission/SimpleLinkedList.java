package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {
    private Node head;
    private Node tail;

    public SimpleLinkedList() {
        this(null);
    }

    public SimpleLinkedList(String[] values) {
        this.head = new Node();
        this.tail = this.head;
        for (String value: values) {
            this.tail.next = new Node(value);
            this.tail = this.tail.next;
        }
    }

    @Override
    public boolean add(String value) {
        return false;
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

    class Node {
        private String value;
        private Node next;

        public Node() {
            this(null);
        }

        public Node(String value) {
            this(value, null);
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
