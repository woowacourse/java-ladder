package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private int size = 0;
    private Node startNode;

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(final String[] values) {
        for (final String value : values) {
            this.add(value);
        }
    }

    @Override
    public boolean add(final String value) {
        final Node newNode = new Node(value, null);
        size += 1;
        if (startNode == null) {
            startNode = newNode;
            return true;
        }
        final Node lastNode = startNode.findLastNode();
        lastNode.setNext(newNode);
        return true;
    }

    @Override
    public void add(final int index, final String value) {
        Node curNode = startNode;
        if (index == 0) {
            startNode = new Node(value, curNode);
            size += 1;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.getNext();
        }
        final Node nodeAtIndex = curNode.getNext();
        curNode.setNext(new Node(value, nodeAtIndex));
        size += 1;
    }

    @Override
    public String set(final int index, final String value) {
        return null;
    }

    @Override
    public String get(final int index) {
        Node curNode = startNode;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getValue();
    }

    @Override
    public boolean contains(final String value) {
        return false;
    }

    @Override
    public int indexOf(final String value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(final String value) {
        return false;
    }

    @Override
    public String remove(final int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    public Node getStartNode() {
        return startNode;
    }
}
