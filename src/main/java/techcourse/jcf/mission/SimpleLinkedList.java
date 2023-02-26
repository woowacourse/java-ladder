package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {


    /*
    미션 2
    SimpleList 인터페이스의 LinkedList 구현체인 SimpleLinkedList 를 구현해본다.
    내부적으로 배열 없이 연결을 유지하여 동작을 이해하는 것을 목표로 한다.
    양방향으로 연결할 필요는 없다. 최대한 단순화하여 구현한다.
     */

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
        Node node = new Node(value);

        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return true;
        }

        tail.link(node);
        tail = node;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(value);
            return;
        }

        Node newNode = new Node(value);
        Node oldNode = head;
        Node beforeNode = null;
        for (int i = 0; i < index; i++) {
            beforeNode = oldNode;
            oldNode = oldNode.getNextNode();
        }

        if (!oldNode.equals(head)) {
            beforeNode.link(newNode);
        }
        if (!oldNode.equals(tail)) {
            newNode.link(oldNode);
        }

        if (oldNode.equals(head)) {
            head = newNode;
        }
        if (oldNode.equals(tail)) {
            tail = newNode;
        }

        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node oldNode = head;
        Node beforeNode = null;
        for (int i = 0; i < index; i++) {
            beforeNode = oldNode;
            oldNode = oldNode.getNextNode();
        }
        Node newNode = new Node(value);

        if (!oldNode.equals(head)) {
            beforeNode.link(newNode);
        }
        if (!oldNode.equals(tail)) {
            newNode.link(oldNode.getNextNode());
        }

        if (oldNode.equals(head)) {
            head = newNode;
        }
        if (oldNode.equals(tail)) {
            tail = newNode;
        }

        return oldNode.getValue();
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getValue();
    }

    @Override
    public boolean contains(String value) {
        if (isEmpty()) {
            return false;
        }

        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(value)) {
                return true;
            }
            node = node.getNextNode();
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        if (isEmpty()) {
            return -1;
        }

        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(value)) {
                return i;
            }
            node = node.getNextNode();
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
        Node node = head;
        Node beforeNode = null;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(value)) {
                break;
            }
            node = node.getNextNode();
        }

        if(node == null){
            return false;
        }

        if (!node.equals(head) && !node.equals(tail)) {
            beforeNode.link(node.getNextNode());
        }
        if (node.equals(head)) {
            head = node.getNextNode();
        }
        if (node.equals(tail)) {
            if(beforeNode != null){
                beforeNode.link(null);
            }
            tail = beforeNode;
        }
        size--;

        return true;
    }

    @Override
    public String remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        Node beforeNode = null;
        for (int i = 0; i < index; i++) {
            beforeNode = node;
            node = node.getNextNode();
        }

        if (!node.equals(head) && !node.equals(tail)) {
            beforeNode.link(node.getNextNode());
        }
        if (node.equals(head)) {
            head = node.getNextNode();
        }
        if (node.equals(tail)) {
            if(beforeNode != null){
                beforeNode.link(null);
            }
            tail = beforeNode;
        }
        size--;

        return node.getValue();
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
