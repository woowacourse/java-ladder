package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node firstNode;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    private Node getNodeAt(int index) {
        validateIndex(index);

        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode();
        }
        return currentNode;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void connect(Node frontNode, Node backNode) {
        if (frontNode != null) {
            frontNode.setNextNode(backNode);
        }
        if (backNode != null) {
            backNode.setPrevNode(frontNode);
        }
    }

    @Override
    public boolean add(String value) {
        if (size == 0) {
            firstNode = new Node(value);
            size++;
            return true;
        }

        final Node newNode = new Node(value);
        final Node lastNode = getNodeAt(size - 1);

        connect(lastNode, newNode);
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (size == 0) {
            firstNode = new Node(value);
            return;
        }

        final Node newNode = new Node(value);
        final Node targetNode = getNodeAt(index);

        connect(targetNode.prevNode(), newNode);
        connect(newNode, targetNode);
        size++;
    }

    @Override
    public String set(int index, String value) {
        final Node newNode = new Node(value);

        if (index == 0 && size > 0) {
            final String originalValue = firstNode.getValue();
            connect(newNode, firstNode.nextNode());
            firstNode = newNode;
            return originalValue;
        }

        final Node originalNode = getNodeAt(index);

        connect(originalNode.prevNode(), newNode);
        connect(newNode, originalNode.nextNode());
        clearNode(originalNode);

        return originalNode.getValue();
    }

    @Override
    public String get(int index) {
        return getNodeAt(index).getValue();
    }

    @Override
    public boolean contains(String value) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (value.equals(currentNode.getValue())) {
                return true;
            }
            currentNode = currentNode.nextNode();
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        final int VALUE_NOT_FOUND_INDEX = -1;
        int index = 0;
        for (Node node = firstNode; node != null; node = node.nextNode()) {
            if (value.equals(node.getValue())) {
                return index;
            }
            index++;
        }
        return VALUE_NOT_FOUND_INDEX;
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
        for (Node node = firstNode; node != null; node = node.nextNode()) {
            if (value.equals(node.getValue())) {
                remove(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        final Node targetNode = getNodeAt(index);
        remove(targetNode);

        return targetNode.getValue();
    }

    private void remove(final Node node) {

        if (node.prevNode() == null) {
            firstNode = node.nextNode();
            if (firstNode != null) {
                firstNode.setPrevNode(null);
            }
            size--;
            clearNode(node);
            return;
        }

        final Node prevNode = node.prevNode();
        final Node nextNode = node.nextNode();

        connect(prevNode, nextNode);
        size--;
        clearNode(node);
    }

    @Override
    public void clear() {
        Node node = firstNode;
        while (node != null) {
            Node prevNode = node;
            node = node.nextNode();
            clearNode(prevNode);
        }
        firstNode = null;
        size = 0;
    }

    private void clearNode(Node node) {
        if (node != null) {
            node.setPrevNode(null);
            node.setNextNode(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node node = firstNode; node != null; node = node.nextNode()) {
            sb.append(node.getValue() + ", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
