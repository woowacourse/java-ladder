package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    class Node {
        private String value;
        private Node nextNode;

        public Node(String value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private Node root;
    private int size;

    public SimpleLinkedList() {
        this.root = new Node();
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node currentNode = root;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = new Node(value);
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node currentNode = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        Node next = currentNode.nextNode;
        currentNode.nextNode = new Node(value);
        currentNode.nextNode.nextNode = next;
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node currentNode = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        Node next = currentNode.nextNode.nextNode;
        String val = currentNode.nextNode.value;
        currentNode.nextNode = new Node(value);
        currentNode.nextNode.nextNode = next;
        return val;
    }

    @Override
    public String get(int index) {
        Node currentNode = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    @Override
    public boolean contains(String value) {
        Node currentNode = root;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.nextNode;
            if (currentNode.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node currentNode = root;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.nextNode;
            if (currentNode.value.equals(value)) {
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
        Node currentNode = root;
        for (int i = 0; i < size - 1; i++) {
            if (currentNode.nextNode.value.equals(value)) {
                Node next = currentNode.nextNode.nextNode;
                currentNode.nextNode = next;
                size--;
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        Node currentNode = root;
        var prev = root;
        var next = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            prev = currentNode;
            currentNode = currentNode.nextNode;
            next = currentNode.nextNode;
        }
        String removeValue = currentNode.value;
        prev.nextNode = next;
        size--;
        return removeValue;
    }

    @Override
    public void clear() {
        root = new Node();
        size = 0;
    }
}