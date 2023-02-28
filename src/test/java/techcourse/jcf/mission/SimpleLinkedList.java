package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleLinkedList implements SimpleList {

    private Node start = new Node();
    private int size = 0;

    @Override
    public boolean add(String value) {
        Node node = new Node(value);
        Node temp = start;
        Node prev;

        while (temp.next != null) {
            temp = temp.next;
        }
        Node nextNode = temp.next;
        node.next = nextNode;
        temp.next = node;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        Node node = new Node(value);
        Node temp = start;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        size++;
        Node nextNode = temp.next;
        node.next = nextNode;
        temp.next = node;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node temp = start;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        String element = temp.next.element;
        temp.next.element = value;
        return element;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node temp = start;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.next.element;
    }

    @Override
    public boolean contains(String value) {
        Node temp = start;

        while (temp.next != null) {
            temp = temp.next;
            if (value.equals(temp.element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node temp = start;
        int index = -1;
        while (temp.next != null) {
            index++;
            temp = temp.next;
            if (value.equals(temp.element)) {
                return index;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        Node temp = start;
        Node prev;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
            if (value.equals(temp.element)) {
                prev.next = temp.next;
                temp = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node next = temp.next;
        temp.next = next.next;
        size--;
        String ret = next.element;
        next = null;
        return ret;

    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }

        Node temp = start.next;

        while (temp.next != null) {
            Node next = temp.next;
            temp = null;
            temp = next;
        }
        size = 0;
    }

    @Override
    public String toString() {
        String[] elements = new String[size];
        Node temp = start;
        int cnt = 0;
        while (temp.next != null) {
            temp = temp.next;
            elements[cnt] = temp.element;
            cnt++;
        }
        return Arrays.toString(elements);
    }
}
