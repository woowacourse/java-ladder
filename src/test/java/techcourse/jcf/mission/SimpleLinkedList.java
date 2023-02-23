package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private int size;
    private Node first;
    private Node last;

    private static class Node {
        String item;
        Node prev;
        Node next;

        Node(Node prev, String item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("[ERROR] add: index 범위가 벗어났습니다.");
        }
        if (index == size) {
            linkLast(value);
        } else {
            linkBefore(value, node(index));
        }
    }

    private void linkLast(String value) {
        Node tempNode = last;
        Node newNode = new Node(last, value, null);
        last = newNode;
        if (tempNode == null) {
            first = newNode;
        } else {
            tempNode.next = newNode;
        }
        size++;
    }

    private void linkBefore(String value, Node node) {
        Node tempNode = node.prev;
        Node newNode = new Node(tempNode, value, node);
        node.prev = newNode;
        if (tempNode == null) {
            first = newNode;
        } else {
            tempNode.next = newNode;
        }
        size++;
    }

    Node node(int index) {
        Node temp;
        if (index < (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    @Override
    public String set(int index, String value) {
        checkIndexRange(index);
        Node temp = node(index);
        String oldValue = temp.item;
        temp.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkIndexRange(index);
        return node(index).item;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (value == null && x.item == null) {
                return index;
            }
            if (value.equals(x.item)) {
                return index;
            }
            index++;
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
        for (Node x = first; x != null; x = x.next) {
            if (value == null && x.item == null) {
                unLink(x);
                return true;
            }
            if (value.equals(x.item)) {
                unLink(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkIndexRange(index);
        return unLink(node(index));
    }

    private String unLink(Node target) {
        String targetValue = target.item;
        Node prev = target.prev;
        Node next = target.next;

        /* prev.next = next; */
        if (prev == null) { // target이 first 노드인 경우
            first = next;
        } else {
            prev.next = next;
            target.prev = null;
        }

        /* next.prev = prev; */
        if (next == null) { // target이 last 노드인 경우
            last = prev;
        } else {
            next.prev = prev;
            target.next = null;
        }

        target.item = null;
        size--;
        return targetValue;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private void checkIndexRange(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("[ERROR] index 범위가 벗어났습니다.");
        }
    }
}
