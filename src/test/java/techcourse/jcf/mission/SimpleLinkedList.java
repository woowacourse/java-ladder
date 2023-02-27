package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private Node tail;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node newNode = new Node(value);
        if (size == 0) {
            addFirst(newNode);
            return true;
        }
        tail.next = newNode;
        tail = newNode;
        size += 1;
        return true;
    }

    private void addFirst(Node newNode) {
        head = newNode;
        tail = newNode;
        size += 1;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }

        if (index != 0) {
            Node previousNode = getNodeByIndex(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size += 1;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String message = String.format("INDEX : %d, SIZE: %d", index, size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private Node getNodeByIndex(int index) {
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        Node oldNode = getNodeByIndex(index);
        String oldValue = oldNode.value;
        oldNode.value = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.value;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) > -1;
    }

    @Override
    public int indexOf(String value) {
        Node target = head;
        for (int i = 0; i < size; i++) {
            if (target.value.equals(value)) {
                return i;
            }
            target = target.next;
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
        int i = indexOf(value);
        if (i < 0) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index == 0) {
            return removeFirstNode();
        }

        if (index == size - 1) {
            return removeLastNode(index);
        }

        Node previousNode = this.getNodeByIndex(index - 1);
        Node currentNode = previousNode.next;

        String oldValue = currentNode.value;

        previousNode.next = currentNode.next;
        currentNode.next = null;

        return oldValue;
    }

    private String removeLastNode(int index) {
        String oldValue = tail.value;
        tail = this.getNodeByIndex(index - 1);
        tail.next = null;
        return oldValue;
    }

    private String removeFirstNode() {
        String oldValue = head.value;
        Node currentHead = head;
        head = currentHead.next;
        size -= 1;

        if (this.isEmpty()) {
            tail = null;
        }
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
