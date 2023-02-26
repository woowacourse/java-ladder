package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node headNode;
    private Node tailNode;
    private int capacity;

    @Override
    public boolean add(String value) {
        Node currNode = new Node(tailNode, null, value);
        tailNode = currNode;
        if (capacity == 0) {
            headNode = currNode;
        }
        capacity++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        checkOutOfIndex(index);
        Node nextNode = findNodeByIndex(index);
        Node prevNode = nextNode.getPrevNode();
        Node currNode = new Node(prevNode, nextNode, value);
        nextNode.setPrevNode(currNode);
        if (prevNode != null) {
            prevNode.setNextNode(currNode);
        }
        capacity++;
    }

    @Override
    public String set(int index, String value) {
        checkOutOfIndex(index);
        Node removeNode = findNodeByIndex(index);
        Node prevNode = removeNode.getPrevNode();
        Node nextNode = removeNode.getNextNode();
        Node currNode = new Node(prevNode, nextNode, value);
        nextNode.setPrevNode(currNode);
        prevNode.setNextNode(currNode);
        return null;
    }

    @Override
    public String get(int index) {
        checkOutOfIndex(index);
        Node node = findNodeByIndex(index);
        return node.getValue();
    }

    @Override
    public boolean contains(String value) {
        Node node = findNodeByValue(value);
        return node != null;
    }

    @Override
    public int indexOf(String value) {
        Node node = headNode;
        for (int index = 0; index < capacity; index++) {
            if (node.getValue().equals(value)) {
                return index;
            }
            node = node.getNextNode();
        }
        return -1;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean remove(String value) {
        Node removeNode = findNodeByValue(value);
        if (removeNode == null) {
            return false;
        }
        Node prevNode = removeNode.getPrevNode();
        Node nextNode = removeNode.getNextNode();
        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        }
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        }
        capacity--;
        return true;
    }

    @Override
    public String remove(int index) {
        Node removeNode = findNodeByIndex(index);
        Node prevNode = removeNode.getPrevNode();
        Node nextNode = removeNode.getNextNode();
        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        }
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        }
        capacity--;
        return removeNode.getValue();
    }

    @Override
    public void clear() {
        headNode = null;
        tailNode = null;
        capacity = 0;
    }

    private Node findNodeByIndex(int index) {
        checkOutOfIndex(index);
        Node node = headNode;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    private Node findNodeByValue(String value) {
        Node node = headNode;
        for (int i = 0; i < capacity; i++) {
            if (node.getValue().equals(value)) {
                return node;
            }
            node = node.getNextNode();
        }
        return node;
    }

    private void checkOutOfIndex(int index) {
        if (index >= capacity) {
            throw new IllegalArgumentException("[ERROR] 인덱스 벗어남");
        }
    }

}

class Node {

    private Node prevNode;
    private Node nextNode;

    private final String value;

    public Node(Node prevNode, Node nextNode, String value) {
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

}
