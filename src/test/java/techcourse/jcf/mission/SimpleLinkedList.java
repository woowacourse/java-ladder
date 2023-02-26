package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList{

    private int size;
    private Node first;
    private Node last;

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    private void linkLast(String value) {
        Node lastNode = last;
        Node newNode = new Node(lastNode, value, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, String value) {
        if (index == size) {
            linkLast(value);
        } else {
            linkBefore(value, node(index));
        }
    }

    private void linkBefore(String value, Node nowNode) {
        Node preNode = nowNode.prev;
        Node newNode = new Node(preNode, value, nowNode);
        nowNode.prev = newNode;
        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        size++;
    }

    private Node node(int index) {
        Node node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public String set(int index, String value) {
        Node node = node(index);
        String oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        return node(index).item;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        for (Node node = first; node != null; node = node.next) {
            if (node.item.equals(value)) {
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
        for (Node node = first; node != null; node = node.next) {
            if (node.item.equals(value)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    private String unlink(Node node) {
        String item = node.item;
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        return unlink(node(index));
    }

    @Override
    public void clear() {
        for (Node node = first; node != null; ) {
            Node next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (Node node = first; node != null; node = node.next) {
            stringBuilder.append(node.item);
            if (node.next != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
