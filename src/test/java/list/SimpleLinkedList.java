package list;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private String value;
        private Node previous;
        private Node next;

        public Node(String value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    @Override
    public boolean add(String value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return true;
        }
        node.previous = tail;
        tail.next = node;
        tail = node;
        size++;
        return true;
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

    public void printAll() {
        Node node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
