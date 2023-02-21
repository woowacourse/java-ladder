package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node node;

    @Override
    public boolean add(String value) {
        if (this.node == null) {
            this.node = new Node(value);
            return true;
        }
        Node node = this.node;
        while (node.hasNextNode()) {
            node = node.getNextNode();
        }
        new Node(value, node);
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);
        validateNull();
        Node foundNode = getNode(index);
        Node newNode = new Node(value, foundNode);
        newNode.setNextNode(foundNode.getNextNode());
        if (index == 0) {
            this.node = newNode;
        }
    }

    private void validateIndex(int index) {
        if (size() > index + 1) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위 초과");
        }
    }

    private void validateNull() {
        if (this.node == null) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위 초과");
        }
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        // 노드가 없을 때
        validateNull();
        // 노드가 한 개 일 때
        if (size() == 1) {
            this.node = new Node(value);
            return value;
        }
        // 노드가 여러 개 일 때
        Node foundPreviousNode = getNode(index - 1);
        Node foundNode = foundPreviousNode.getNextNode();
        Node newNode = new Node(value, foundNode.getNextNode());
        foundPreviousNode.setNextNode(newNode);
        return value;
    }

    @Override
    public String get(int index) {
        return getNode(index).getValue();
    }

    private Node getNode(int index) {
        Node node = this.node;
        for (int i = 0; i < index; i++) {
            node = this.node.getNextNode();
        }
        return node;
    }

    @Override
    public boolean contains(String value) {
        Node node = this.node;
        while (true) {
            if (node.isValueMatch(value)) {
                return true;
            }
            if (!node.hasNextNode()) {
                break;
            }
            node = node.getNextNode();
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        if (node == null) {
            return -1;
        }
        int index = 0;
        Node node = this.node;
        while (true) {
            if (node.isValueMatch(value)) {
                return index;
            }
            if (!node.hasNextNode()) {
                break;
            }
            node = node.getNextNode();
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        if (this.node == null) {
            return 0;
        }
        int size = 1;
        Node node = this.node;
        while (node.hasNextNode()) {
            node = node.getNextNode();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    @Override
    public boolean remove(String value) {
        if (node == null) {
            return false;
        }
        Node node = this.node;
        if (size() == 1) {
            this.node = null;
        }
        while (true) {
            if (!node.hasNextNode()) {
                return false;
            }
            Node nextNode = node.getNextNode();
            if (nextNode.isValueMatch(value)) {
                node.setNextNode(nextNode.getNextNode());
                break;
            }
            node = node.getNextNode();
        }
        return true;
    }

    @Override
    public String remove(int index) {
        if (node == null) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위 초과");
        }
        if (size() == 1) {
            String value = this.node.getValue();
            this.node = null;
            return value;
        }
        Node previousNode = getNode(index - 1);
        Node targetNode = previousNode.getNextNode();
        previousNode.setNextNode(targetNode);
        return targetNode.getValue();
    }

    @Override
    public void clear() {
        this.node = null;
    }
}
