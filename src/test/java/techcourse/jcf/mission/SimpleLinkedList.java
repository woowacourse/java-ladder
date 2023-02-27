package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node first;
    private Node last;

    private int size = 0;


    @Override
    public boolean add(String value) {
        if (size++ == 0) {
            first = last = new Node(null, value, null);
            return true;
        }
        Node node = new Node(last, value, null);
        last.next = node;
        last = node;
        if (first.next == null) {
            first.next = last;
        }
        return false;
    }

    @Override
    public void add(int index, String value) {
        if (index != size) {
            checkWrongIndex(index);
        }
        if (index == 0) {
            Node newFirst = new Node(null, value, first);
            first.prev = newFirst;
            first = newFirst;
        } else if (index == size) {
            add(value);
        } else {
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;
            Node middleNode = new Node(prevNode, value, nextNode);
            prevNode.next = middleNode;
            nextNode.prev = middleNode;
        }
        size++;


    }

    private Node getNode(int index) {
        Node nextNode = first;
        for (int i = 0; i < index; i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
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
        checkWrongIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    private void checkWrongIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("잘못된 인덱스 참조");
        }
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        Node node = getNodeFromValue(value);
        if (node == first){
            first = node.next;
            first.prev = null;
            node.item=null;
            node.prev=null;
            node.next=null;

        } else if (node == last) {
            last = node.prev;
            node.prev=null;
            node.item=null;

        }
        else {
            Node leftNode = node.prev;
            Node rightNode = node.next;
            leftNode.next = rightNode;
            rightNode.prev = leftNode;
            node.prev=null;
            node.item=null;
            node.next=null;
        }
        size--;
        return true;
    }

    private Node getNodeFromValue(String value) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(value)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public String remove(int index) {
        checkWrongIndex(index);
        Node node = getNode(index);
        String OldValue = node.item;
        if (node == first){
            first = node.next;
            first.prev = null;
            node.item=null;
            node.prev=null;
            node.next=null;

        } else if (node == last) {
            last = node.prev;
            node.prev=null;
            node.item=null;

        }
        else {
            Node leftNode = node.prev;
            Node rightNode = node.next;
            leftNode.next = rightNode;
            rightNode.prev = leftNode;
            node.prev=null;
            node.item=null;
            node.next=null;
        }
        size--;
        return OldValue;
    }

    @Override
    public void clear() {
        Node node = first;
        for (Node x = first; x != null; ) {
            Node next = node.next;
            x.prev = null;
            x.item = null;
            x.next = null;
        }
        size = 0;
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
}
