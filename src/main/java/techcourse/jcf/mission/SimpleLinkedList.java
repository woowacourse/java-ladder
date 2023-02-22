package techcourse.jcf.mission;

import java.util.Objects;
import java.util.StringJoiner;

public class SimpleLinkedList implements SimpleList {

    private int size = 0;
    private Node first;
    private Node last;

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index == size) {
            linkLast(value);
            return;
        }
        linkBefore(index, value);
    }

    private void linkLast(String value) {
        final Node currentLast = last;
        final Node newNode = new Node(value, null);

        last = newNode;
        if (currentLast == null) {
            first = newNode;
            size++;
            return;
        }
        currentLast.next = newNode;
        size++;
    }

    private void linkBefore(int index, String value) {
        validateIndexRange(index);
        final Node prev = node(index - 1);
        final Node before = node(index);
        final Node newNode = new Node(value, before);

        if (prev == null) {
            first = newNode;
            size++;
            return;
        }
        prev.next = newNode;
        size++;
    }

    private Node node(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node found = first;
        for (int i = 0; i < index; i++) {
            found = found.next;
        }
        return found;
    }

    @Override
    public String set(int index, String value) {
        validateIndexRange(index);
        Node target = node(index);
        String oldValue = target.item;
        target.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        validateIndexRange(index);
        return node(index).item;
    }

    @Override
    public boolean contains(String value) {
        Node found = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(found.item, value)) {
                return true;
            }
            found = found.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node found = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(found.item, value)) {
                return i;
            }
            found = found.next;
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
        int index = indexOf(value);

        if (index == 0) {
            first = first.next;
            size--;
            return true;
        }
        if (index > 0) {
            Node before = node(index - 1);
            before.next = node(index + 1);
            size--;
            return true;
        }

        return false;
    }

    @Override
    public String remove(int index) {
        validateIndexRange(index);
        Node target = node(index);

        if (index == 0) {
            first = first.next;
        }
        if (index > 0) {
            Node before = node(index - 1);
            before.next = node(index + 1);
        }
        size--;
        return target.item;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스의 범위가 올바르지 않습니다. index: " + index);
        }
    }

    private static class Node {
        String item;
        Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringJoiner nodes = new StringJoiner(", ", "[", "]");
        Node node = first;
        for (int i = 0; i < size; i++) {
            nodes.add(node.item);
            node = node.next;
        }
        return nodes.toString();
    }
}
