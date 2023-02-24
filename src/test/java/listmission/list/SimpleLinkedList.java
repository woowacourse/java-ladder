package listmission.list;

import java.util.UUID;

public class SimpleLinkedList implements SimpleList {

    private final Node head;

    public SimpleLinkedList() {
        this.head = new Node();
    }

    @Override
    public boolean add(String value) {
        assertNull(value);

        Node tmpNode = head;
        while (tmpNode.hasNext()) {
            tmpNode = tmpNode.getNext();
        }

        tmpNode.addNext(new Node(value));
        return true;
    }

    @Override
    public void add(int index, String value) {
        assertNull(value);

        Node tmpNode = head;
        int cursor = 0;
        while (tmpNode.hasNext()
                && cursor < index) {
            tmpNode = tmpNode.getNext();
            cursor += 1;
        }

        Node nextNode = new Node(value);
        nextNode.addNext(tmpNode.getNext());
        tmpNode.addNext(nextNode);
    }

    private void assertNull(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public String set(int index, String value) {
        Node tmpNode = head;
        int cursor = 0;

        while (tmpNode.hasNext()
                && cursor <= index) {
            tmpNode = tmpNode.getNext();
            cursor += 1;
        }

        if (cursor < index) {
            throw new IndexOutOfBoundsException();
        }

        tmpNode.setData(value);
        return value;
    }

    @Override
    public String get(int index) {
        Node tmpNode = head;
        int cursor = 0;

        while (tmpNode.hasNext()
                && cursor <= index) {
            tmpNode = tmpNode.getNext();
            cursor += 1;
        }

        if (cursor < index) {
            throw new IndexOutOfBoundsException();
        }

        return tmpNode.getData();
    }

    @Override
    public boolean contains(String value) {
        Node tmpNode = head;

        while (tmpNode.hasNext()) {
            tmpNode = tmpNode.getNext();
            if (tmpNode.getData().equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        Node tmpNode = head;
        int index = 0;

        while (tmpNode.hasNext()) {
            tmpNode = tmpNode.getNext();
            if (tmpNode.getData().equals(value)) {
               break;
            }
            index += 1;
        }

        return index;
    }

    @Override
    public int size() {
        Node tmpNode = head;
        int size = 0;

        while (tmpNode.hasNext()) {
            tmpNode = tmpNode.getNext();
            size += 1;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        Node tmpNode = head;
        int cursor = 0;

        while (tmpNode.hasNext()
                && cursor < index) {
            tmpNode = tmpNode.getNext();
            cursor += 1;
        }

        Node next = tmpNode.getNext();
        String removedData = next.getData();

        Node nextOfNext = next.getNext();
        tmpNode.addNext(nextOfNext);
        next.addNext(null);

        return removedData;
    }

    @Override
    public void clear() {
        this.head.addNext(null);
    }
}

class Node {

    private static final String DEFAULT_DATA = UUID.randomUUID().toString();
    private String data;
    private Node next = null;

    public Node() {
        this.data = DEFAULT_DATA;
    }

    public Node(String data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void addNext(Node node) {
        this.next = node;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
