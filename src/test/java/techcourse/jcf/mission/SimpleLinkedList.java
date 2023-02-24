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
    public String get(int index) {
        Node pointer = getNodeOf(index);
        return pointer.value;
    }

    @Override
    public boolean add(String value) {
        this.tail.next = new Node(value);
        this.tail = this.tail.next;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node prevPointer = this.head;
        Node nextPointer = this.head;
        for (int i = 0; i <= index; i++) {
            prevPointer = nextPointer;
            if (prevPointer == null) {
                throw new IndexOutOfBoundsException();
            }
            nextPointer = nextPointer.next;
        }
        prevPointer.next = new Node(value, nextPointer);
    }

    @Override
    public String set(int index, String value) {
        Node pointer = getNodeOf(index);
        String valueBeforeSet = pointer.value;
        pointer.value = value;
        return valueBeforeSet;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pointer = this.head.next;
        while (pointer != null) {
            sb.append(pointer.value);
            sb.append(", ");
            pointer = pointer.next;
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        return sb.toString();
    }

    private Node getNodeOf(int index) {
        Node pointer = this.head;
        for (int i = 0; i <= index; i++) {
            pointer = pointer.next;
            if (pointer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return pointer;
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
    }
}
