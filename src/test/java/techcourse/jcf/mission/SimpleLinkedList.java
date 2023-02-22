package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {
    private Node head;
    private int size = 0;

    public SimpleLinkedList() {
        this.head = new Node();
    }

    class Node {
        private Node next;
        private String value;

        public Node() {
            this.next = null;
            this.value = null;
        }

        public Node(String value) {
            this.value = value;
        }
    }

    @Override
    public boolean add(String value) {
        Node newNode = new Node(value);
        Node nowNode = head;
        while (nowNode.next != null) {
            nowNode = nowNode.next;
        }
        nowNode.next = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        // head 다음 노드부터가 0번 인덱스
        validateIndexRange(index);
        Node prevNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node nowNode = prevNode.next;
        Node newNode = new Node(value);
        prevNode.next = newNode;
        newNode.next = nowNode;
        size++;
    }

    @Override
    public String set(int index, String value) {
        validateIndexRange(index);
        Node nowNode = head;
        for (int i = 0; i <= index; i++) {
            nowNode = nowNode.next; // 찾고자 하는 인덱스의 노드
        }

        String prevValue = nowNode.value;
        nowNode.value = value;
        return prevValue;
    }

    @Override
    public String get(int index) {
        validateIndexRange(index);

        Node nowNode = head;

        for (int i = 0; i <= index; i++) {
            nowNode = nowNode.next;
        }

        return nowNode.value;
    }

    @Override
    public boolean contains(String value) {
        int foundIndex = indexOf(value);
        return foundIndex != -1;
    }

    @Override
    public int indexOf(String value) {
        Node nowNode = head;
        for (int i = 0; i < size; i++) {
            nowNode = nowNode.next;
            if (nowNode.value.equals(value)) {
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
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        Node prevNode = head;
        Node deleteNeedNode;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        deleteNeedNode = prevNode.next;
        prevNode.next = deleteNeedNode.next;
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        validateIndexRange(index);

        Node prevNode = head;
        Node deleteNeedNode;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        deleteNeedNode = prevNode.next;
        String deletedValue = deleteNeedNode.value;
        prevNode.next = deleteNeedNode.next;
        size--;
        return deletedValue;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
