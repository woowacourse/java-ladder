package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleLinkedList implements SimpleList {
    private Node head = new Node();
    private int size = 0;

    @Override
    public boolean add(String value) {
        Node node = new Node(value);

        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
        size++;

        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);

        Node ptr = getPreviousNode(index);

        Node newNode = new Node(value);
        newNode.next = ptr.next;
        ptr.next = newNode;
        size++;
    }

    private Node getPreviousNode(int index) {
        Node ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        return ptr;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);

        Node ptr = getPreviousNode(index).next;

        String previous = ptr.value;
        ptr.value = value;

        return previous;
    }

    @Override
    public String get(int index) {
        validateIndex(index);

        return getPreviousNode(index).next.value;
    }

    @Override
    public boolean contains(String value) {
        Node ptr = head;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            if (ptr.value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        Node ptr = head;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            if (ptr.value.equals(value)) {
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
        int index = -1;

        Node ptr = head;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            if (ptr.value.equals(value)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        Node previous = getPreviousNode(index);
        previous.next = ptr.next;

        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        Node previous = getPreviousNode(index);
        String result = previous.next.value;
        previous.next = previous.next.next;

        size--;
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        head = new Node();
    }

    @Override
    public String toString() {
        String[] result = new String[size];

        Node ptr = head;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            result[i] = ptr.value;
        }

        return Arrays.toString(result);
    }

    static class Node {
        private String value;
        private Node next;

        private Node(String value) {
            this.value = value;
            next = null;
        }

        private Node() {
            this("");
        }
    }
}
