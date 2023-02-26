package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    Node head;

    public SimpleLinkedList() {
        head = new Node(null);
    }

    @Override
    public boolean add(String value) {
        Node lastNode = getLastNode();

        Node newNode = new Node(value);
        lastNode.setNext(newNode);
        return true;
    }

    @Override
    public void add(int index, String value) {
        validate(index);

        Node lastNode = getNode(index - 1);

        Node newNode = new Node(value);
        newNode.setNext(lastNode.getNext());
        lastNode.setNext(newNode);
    }

    @Override
    public String set(int index, String value) {
        validate(index);

        Node lastNode = getNode(index - 1);

        Node removed = lastNode.getNext();
        Node newNode = new Node(value);
        newNode.setNext(removed.getNext());
        lastNode.setNext(newNode);
        return removed.getValue();
    }

    @Override
    public String get(int index) {
        validate(index);

        Node node = getNode(index);

        return node.getValue();
    }

    @Override
    public boolean contains(String value) {
        Node lastNode = head;

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            if (lastNode.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        Node lastNode = head;
        int currentIndex = -1;

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            currentIndex++;
            if (lastNode.getValue().equals(value)) {
                return currentIndex;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        Node lastNode = head;
        int count = 0;

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            count++;
        }

        return count;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public boolean remove(String value) {
        Node lastNode = head;

        Node removed = null;
        while (lastNode.getNext() != null) {
            if (lastNode.getNext().getValue().equals(value)) {
                removed = lastNode.getNext();
                break;
            }
            lastNode = lastNode.getNext();
        }

        if (removed == null) {
            return false;
        }

        lastNode.setNext(removed.getNext());
        return true;
    }

    @Override
    public String remove(int index) {
        validate(index);

        Node lastNode = getNode(index - 1);
        Node removed = lastNode.getNext();
        lastNode.setNext(removed.getNext());

        return removed.getValue();
    }

    @Override
    public void clear() {
        head = new Node(null);
    }

    @Override
    public String toString() {
        Node lastNode = head;
        String result = "[";

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            result += lastNode.getValue();
            if (lastNode.getNext() != null) {
                result += ", ";
            }
        }

        result += "]";
        return result;
    }

    private void validate(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("인덱스가 벗어나면 예외를 발생시킨다.");
        }
    }

    private Node getNode(int index) {
        Node lastNode = head;
        int currentIndex = -1;

        while (currentIndex < index) {
            lastNode = lastNode.getNext();
            if (lastNode == null) {
                throw new IndexOutOfBoundsException("인덱스가 벗어나면 예외를 발생시킨다.");
            }
            currentIndex++;
        }

        return lastNode;
    }

    private Node getLastNode() {
        Node lastNode = head;

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        return lastNode;
    }
}
