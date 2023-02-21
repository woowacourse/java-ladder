package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    Node head, tail;
    int size = 0;

    private class Node {
        String value;
        Node prev;
        Node next;

        public Node(String value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(String value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = head;
        size++;
    }

    public void addPrev(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public boolean add(String value) {
        if (size == 0) {
            addFirst(value);
            return true;
        }
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index == 0) {
            if (size == 0) {
                addFirst(value);
                return;
            }
            addPrev(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node newNode = new Node(value);
        Node prevNode = getNode(index - 1);
        Node nextNode = prevNode.next;

        newNode.prev = prevNode;
        newNode.next = nextNode;

        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;
    }

    private Node getNode(int index) {
        Node pointNode = head;
        for (int i = 0; i < index; i++) {
            pointNode = head.next;
        }
        return pointNode;
    }

    @Override
    public String set(int index, String value) {
        Node pointNode = getNode(index - 1);
        String oldValue = pointNode.next.value;
        pointNode.next.value = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        Node pointNode = head;
        for (int i = 0; i < index; i++) {
            pointNode = head.next;
        }
        return pointNode.value;
    }

    @Override
    public boolean contains(String value) {
        Node pointNode = head;
        for (int i = 0; i < size; i++) {
            if (pointNode.value.equals(value)) {
                return true;
            }
            pointNode = head.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) throws Exception {
        return 0;
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
        return false;
    }

    @Override
    public String remove(int index) {
        String oldValue = getNode(index).value;
        if(index==0){
            if (size == 1) {
                head = null;
                size--;
                return oldValue;
            }
            head = getNode(index+1);
            size--;
            return oldValue;
        }

        if (index == size) {
            getNode(index).prev = tail;
            size--;
            return oldValue;
        }
        getNode(index + 1).prev = getNode(index - 1);
        getNode(index - 1).next = getNode(index + 1);
        size--;
        return oldValue;
    }

    @Override
    public void clear() {

    }
}
