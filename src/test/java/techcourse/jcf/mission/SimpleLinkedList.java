package techcourse.jcf.mission;

import static java.text.MessageFormat.format;

public class SimpleLinkedList implements SimpleList {

    private Node start;
    private int size;

    public SimpleLinkedList() {
        this.start = null;
        this.size = 0;
    }

    @Override
    public boolean add(final String value) {
        Node node = new Node(value);
        Node last = lastNode();
        if (last == null) {
            start = node;
        } else {
            connectBefore(node, last);
        }
        size++;
        return true;
    }

    private Node lastNode() {
        Node last = start;
        while (last != null && last.next != null) {
            last = last.next;
        }
        return last;
    }

    private void connectBefore(final Node node, final Node before) {
        node.next = before.next;
        before.next = node;
    }

    @Override
    public void add(final int index, final String value) {
        validateIndexForAdd(index);
        if (index == size) {
            add(value);
        } else if (index == 0) {
            Node node = new Node(value);
            node.next = start;
            start = node;
            size++;
        } else {
            Node before = nodeAt(index - 1);
            Node node = new Node(value);
            connectBefore(node, before);
            size++;
        }
    }

    private Node nodeAt(int index) {
        Node target = start;
        while (index-- > 0) {
            target = target.next;
        }
        return target;
    }

    private void validateIndexForAdd(final int index) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException(format("해당 인덱스에서 작업을 수행할 수 없습니다. 인덱스: {0}, 크기: {1}", index, size));
        }
    }

    @Override
    public String set(final int index, final String value) {
        validateIndex(index);
        Node node = nodeAt(index);
        String prev = node.value;
        node.value = value;
        return prev;
    }

    private void validateIndex(final int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException(format("해당 인덱스에서 작업을 수행할 수 없습니다. 인덱스: {0}, 크기: {1}", index, size));
        }
    }

    @Override
    public String get(final int index) {
        validateIndex(index);
        Node node = nodeAt(index);
        return node.value;
    }

    @Override
    public boolean contains(final String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(final String value) {
        Node node = start;
        int index = 0;
        while (node != null) {
            if (node.value.equals(value)) {
                return index;
            }
            index++;
            node = node.next;
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
    public boolean remove(final String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        } else if (index == 0) {
            start = start.next;
        } else if (index == size - 1) {
            Node node = nodeAt(index - 1);
            node.next = null;
        } else {
            Node node = nodeAt(index - 1);
            node.next = node.next.next;
        }
        size--;
        return true;
    }

    @Override
    public String remove(final int index) {
        validateIndex(index);
        String remove;
        if (index == 0) {
            remove = start.value;
            start = start.next;
        } else if (index == size - 1) {
            Node node = nodeAt(index - 1);
            remove = node.next.value;
            node.next = null;
        } else {
            Node node = nodeAt(index - 1);
            remove = node.next.value;
            node.next = node.next.next;
        }
        size--;
        return remove;
    }

    @Override
    public void clear() {
        Node node = start;
        while (node != null) {
            Node next = node.next;
            node.value = null;
            node.next = null;
            node = next;
        }
        this.size = 0;
    }
}
