package study;

public class SimpleLinkedList implements SimpleList {
    Node head;
    Node tail;
    int size;

    public SimpleLinkedList() {
        head = new Node("Head", null, null);
        tail = new Node("Tail", null, null);
        size = 0;
        head.next = tail;
        tail.previous = head;
    }


    @Override
    public boolean add(String value) {
        Node node = new Node(value, tail.previous, tail);
        tail.previous.next = node;
        tail.previous = node;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node previous = head;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node node = new Node(value, previous, previous.next);
        previous.next.previous = node;
        previous.next = node;
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node previous = head;
        for (int i = 0; i <= index; i++) {
            previous = head.next;
        }
        String oldValue = previous.value;
        previous.value = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public boolean contains(String value) {
        Node node = head.next;
        while (!node.equals(tail)) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node node = head.next;
        for (int i = 0; !node.equals(tail); i++) {
            if (node.value.equals(value)) {
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
        Node node = head.next;
        boolean isRemoved = false;
        while (!node.equals(tail)) {
            if (node.value.equals(value)) {
                size--;
                isRemoved = true;
                node.next.previous = node.previous;
                node.previous.next = node.next;
            }
        }
        return isRemoved;
    }

    @Override
    public String remove(int index) {
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next.previous = node.previous;
        node.previous.next = node.next;
        size--;
        return node.value;
    }

    @Override
    public void clear() {
        head = new Node("Head", null, null);
        tail = new Node("Tail", null, null);
        size = 0;
        head.next = tail;
        tail.previous = head;
    }

    private static class Node {
        private String value;
        private Node previous;
        private Node next;

        public Node(String value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
