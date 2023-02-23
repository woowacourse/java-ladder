package techcourse.jcf.mission;

import java.util.LinkedList;

public class SimpleLinkedList implements SimpleList {

    private static class Node {
        String value;
        SimpleLinkedList.Node next;
        SimpleLinkedList.Node prev;

        public Node(String value) {
            this.value = value;
        }

        public Node(Node prev, String value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateOutOfIndex(index);

        if (index == size)
            linkLast(value);
        else
            linkBefore(value, findNode(index));
    }

    @Override
    public String set(int index, String value) {
        validateOutOfIndex(index);

        Node x = findNode(index);
        String preValue = x.value;
        x.setValue(value);
        return preValue;
    }

    @Override
    public String get(int index) {
        validateOutOfIndex(index);

        Node result = first;
        for (int i = 0; i < index; i++) {
           result = result.next;
        }
        return result.value;
    }

    @Override
    public boolean contains(String value) {
        Node x = first;
        for (int i = 0; i < size; i++) {
            if (x.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node x = first;
        for (int i = 0; i < size; i++) {
            if (x.value.equals(value)) {
                return i;
            }
            x = x.next;
        }
        throw new IllegalArgumentException("리스트 내에 존재하지 않는 값입니다.");
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
        if (value == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.value == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (value.equals(x.value)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        validateOutOfIndex(index);
        Node x = findNode(index);
        String preValue = x.value;
        unlink(x);
        return preValue;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    Node findNode(int index) {
        // assert isElementIndex(index);
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    void linkLast(String value) {
        final Node l = last;
        final Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void linkBefore(String value, Node succ) {
        // assert succ != null;
        final Node pred = succ.prev;
        final Node newNode = new Node(pred, value, succ);

        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    String unlink(Node x) {
        // assert x != null;
        final String element = x.value;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.value = null;
        size--;
        return element;
    }

    private void validateOutOfIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("범위 밖의 인덱스 입니다.");
        }
    }
}
