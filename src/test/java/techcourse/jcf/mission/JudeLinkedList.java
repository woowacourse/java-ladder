package techcourse.jcf.mission;

public class JudeLinkedList implements SimpleList{

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

    public JudeLinkedList() {
        this.root = new Node();
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node nodeNow = root;
        while (nodeNow.nextNode != null) {
            nodeNow = nodeNow.nextNode;
        }
        nodeNow.nextNode = new Node(value);
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node nodeNow = root;

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            nodeNow = nodeNow.nextNode;
        }
        Node next = nodeNow.nextNode;

        nodeNow.nextNode = new Node(value);
        nodeNow.nextNode.nextNode = next;

        size++;

    }

    @Override
    public String set(int index, String value) { //1
        Node nodeNow = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            nodeNow = nodeNow.nextNode;// 0
        }
        Node next = nodeNow.nextNode.nextNode; // 2
        String val = nodeNow.nextNode.value; //0.val
        nodeNow.nextNode = new Node(value); // 1
        nodeNow.nextNode.nextNode = next; // 2

        return val;
    }

    @Override
    public String get(int index) {
        Node nodeNow = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            nodeNow = nodeNow.nextNode;
        }
        return nodeNow.value;
    }

    @Override
    public boolean contains(String value) {
        Node now = root;
        for (int i = 0; i < size; i++) {
            now = now.nextNode;
            if (now.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        var now = root;
        for (int i = 0; i < size; i++) {
            now = now.nextNode;
            if (now.value.equals(value)) {
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
        Node now = root;
        for (int i = 0; i < size - 1; i++) {
            if (now.nextNode.value.equals(value)) {
                var next = now.nextNode.nextNode;
                now.nextNode = next;
                size--;
                return true;
            }
            now = now.nextNode;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        Node now = root;
        var prev = root;
        var next = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            prev = now;
            now = now.nextNode;
            next = now.nextNode;
        }
        var val = now.value;
        prev.nextNode = next;
        size--;
        return val;
    }

    @Override
    public void clear() {
        root = new Node();
        size = 0;
    }

    @Override
    public String toString() {
        var now = root;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            now = now.nextNode;
            sb.append(now.value).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
