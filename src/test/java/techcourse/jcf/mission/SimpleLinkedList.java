package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node node;
    private int size = 0;

    @Override
    public boolean add(String value) {
        if (node == null) {
            this.node = new Node(value);
            size++;
            return true;
        }
        Node node = getLastNode();
        new Node(value, node, null);
        size++;
        return true;
    }

    private Node getLastNode() {
        Node node = this.node;
        while (node.hasNextNode()) {
            node = node.getNextNode();
        }
        return node;
    }


    @Override
    public void add(int index, String value) {
        Node foundNode = getNode(index);
        Node newNode = new Node(value, foundNode.getPrevNode(), foundNode);
        if (index == 0) {
            this.node = newNode;
        }
        size++;
    }

    private Node getNode(int index) {
        validateIndex(index);
        Node node = this.node;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    private void validateIndex(int index) {
        if (index + 1 > size || index < 0) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위 초과");
        }
    }

    @Override
    public String set(int index, String value) {
        Node foundNode = getNode(index);
        Node newNode = new Node(value, foundNode.getPrevNode(), foundNode.getNextNode());
        if (index == 0) {
            this.node = newNode;
        }
        return value;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return getNode(index).getValue();
    }

    @Override
    public boolean contains(String value) {
        for (Node node = this.node; node != null; node = node.getNextNode()) {
            if (node.isValueMatch(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        for (Node node = this.node; node != null; node = node.getNextNode()) {
            if (node.isValueMatch(value)) {
                return index;
            }
            index++;
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
        for (Node node = this.node; node != null; node = node.getNextNode()) {
            if (node.isValueMatch(value)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    private void unlink(Node node) {
        Node prevNode = node.getPrevNode();
        Node nextNode = node.getNextNode();
        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        }
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        }
        if (size == 1) {
            this.node = null;
        }
        size--;
    }

    @Override
    public String remove(int index) {
        Node foundNode = getNode(index);
        unlink(foundNode);
        return foundNode.getValue();
    }

    @Override
    public void clear() {
        this.node = null;
        this.size = 0;
    }
}
