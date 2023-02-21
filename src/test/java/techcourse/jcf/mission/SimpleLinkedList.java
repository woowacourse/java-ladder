package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node first;
    private Node last;

    private int size;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private static class Node {

        String item;
        Node next;
        Node prev;

        Node(Node prev, String element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public boolean add(String value) {
        if (size++ == 0) {
            first = last = new Node(null, value, null);
            return true;
        }
        Node node = new Node(last, value, null);
        last.next = node;
        last = node;
        if (first.next == null && size == 1) {
            first.next = last;
        }
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index != size) {
            checkIndex(index);
        }
        if (index == 0) {
            Node oldFirst = first;
            first = new Node(null, value, oldFirst);
        } else if (index == size) {
            add(value);
        } else {
            Node next = getNode(index);
            Node prev = next.prev;
            Node current = new Node(prev, value, next);
            next.prev = current;
            prev.next = current;
        }
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node node = getNode(index);
        String oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        Node node = getNode(index);
        return node.item;
    }

    @Override
    public boolean contains(String value) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(value)) {
                return i;
            }
            node = node.next;
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
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(value)) {
                break;
            }
            node = node.next;
        }
        if (node == null) {
            return false;
        } else if (size == 1) {
            clear();
        } else if (node == first) {
            first = node.next;
            node.item = null;
            node.prev = null;
            node.next.prev = null;
            node.next = null;
        } else if (node == last) {
            last = node.prev;
            node.prev = null;
            node.item = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
            node.item = null;
        }
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        Node node = getNode(index);
        String oldValue = node.item;
        if (size == 1) {
            clear();
        } else if (node == first) {
            first = node.next;
            node.item = null;
            node.prev = null;
            node.next.prev = null;
            node.next = null;
        } else if (node == last) {
            last = node.prev;
            node.prev = null;
            node.item = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
            node.item = null;
        }
        size--;
        return oldValue;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
