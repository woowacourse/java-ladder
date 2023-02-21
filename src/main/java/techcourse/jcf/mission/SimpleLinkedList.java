package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private Node tail;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node node = new Node(value, null);
        if (size == 0) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            this.tail = node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index >= size) {
            for (int i = size; i < index; i++) {
                add(null);
            }
            add(value);
        } else {
            Node newNode = new Node(value, null);
            Node prevNode = getNode(index - 1);
            Node original = getNode(index);
            prevNode.next = newNode;
            newNode.next = original;
            size++;
        }
    }

    @Override
    public String set(int index, String value) {
        Node original = getNode(index);
        Node newNode = new Node(value, null);
        Node prevNode = getNode(index - 1);
        Node nextNode = getNode(index + 1);
        prevNode.next = newNode;
        newNode.next = nextNode;
        return original.element;
    }

    @Override
    public String get(int index) {
        return getNode(index).element;
    }

    @Override
    public boolean contains(String value) {
        if (indexOf(value) == -1)
            return false;
        return true;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).element.equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        if (indexOf(value) == -1)
            return false;
        remove(indexOf(value));
        return true;
    }

    @Override
    public String remove(int index) {
        Node removed = getNode(index);
        Node prevNode = getNode(index - 1);
        Node nextNode = getNode(index + 1);
        prevNode.next = nextNode;
        return removed.element;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    class Node {

        String element;
        Node next;

        public Node(String element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
