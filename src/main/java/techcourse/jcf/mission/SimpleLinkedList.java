package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node first;
    private Node last;
    private int size;

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

    public SimpleLinkedList() {
        size = 0;
    }

    @Override
    public boolean add(String value) {
        if (first == null) {
            first = new Node(null, value, null);
            last = first;
            size = size + 1;
            return true;
        }
        last.next = new Node(last, value, null);
        last = last.next;
        size = size + 1;
        return true;
    }

    // index = 1, now
    @Override
    public void add(int index, String value) {
        if (index == 0) {
            Node newNode = new Node(null, value, first);
            first.prev = newNode;
            first = newNode;
            size = size + 1;
            return;
        }
        // 0 first 1 second 2 fourth || index : 2, value : third
        if (index > 0 && index < size) {
            Node now = first;
            for (int i = 0; i < index; i++) {
                now = now.next;
            }
            Node newNode = new Node(now.prev, value, now);
            now.prev.next = newNode;
            now.prev = newNode;
            size = size + 1;
            return;
        }
        if (index == size) {
            Node newNode = new Node(last, value, null);
            last.next = newNode;
            last = newNode;
            size = size + 1;
            return;
        }
        if (index == size + 1) {
            add(value);
        }

    }

    @Override
    public String set(int index, String value) {
        Node now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        String oldItem = now.item;
        now.item = value;
        return oldItem;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return now.item;
    }

    @Override
    public boolean contains(String value) {
        Node now = first;
        while (!now.item.equals(value)) {
            if (now.next == null) {
                return false;
            }
            now = now.next;
        }
        return true;
    }

    @Override
    public int indexOf(String value) {
        Node now = first;
        int count = 0;
        while (now.next != null) {
            if (value.equals(now.item)) {
                return count;
            }
            count = count + 1;
            now = now.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (first == null) && (last == null);
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        return remove(index).equals(value);
    }

    @Override
    public String remove(int index) {
        Node now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        String item = now.item;
        if (index == 0) {
            now.next.prev = null;
            first = now.next;
            return item;
        }
        if (index > 0 && index < size - 1) {
            now.next.prev = now.prev;
            now.prev.next = now.next;
            return item;
        }
        if (index == size - 1) {
            now.prev.next = null;
            last = now.prev;
            return item;
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }
}
