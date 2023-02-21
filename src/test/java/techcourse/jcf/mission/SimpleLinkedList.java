package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {
    private static class Node {
        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private final Node head;

    public SimpleLinkedList() {
        this.head = new Node(null, null);
    }

    @Override
    public boolean add(String value) {
        Node nextNode = new Node(value, null);
        Node lastNode = findLastNode();
        lastNode.setNext(nextNode);
        return true;
    }

    private Node findLastNode() {
        if (head.next == null) {
            return head;
        }
        Node traverseNode = head;
        while (traverseNode.next != null) {
            traverseNode = traverseNode.next;
        }
        return traverseNode;
    }

    @Override
    public void add(int index, String value) {
        Node node = findNodeByIndex(index);
        Node nextNode = new Node(value, null);
        if (node.next.next != null) {
            nextNode.next = node.next.next;
        }
        node.next = nextNode;
    }

    private Node findNodeByIndex(int index) {
        int count = 0;
        Node traverseNode = head;
        while (traverseNode.next != null && count <= index) {
            traverseNode = traverseNode.next;
            count++;
        }
        return traverseNode;
    }

    @Override
    public String set(int index, String value) {
        Node indexNode = findNodeByIndex(index);
        String oldValue = indexNode.value;
        indexNode.setValue(value);
        return oldValue;
    }

    @Override
    public String get(int index) {
        return findNodeByIndex(index).value;
    }

    @Override
    public boolean contains(String value) {
        Node traverseNode = new Node(head.value, head.next);
        while (traverseNode.next != null) {
            if (traverseNode.next.value.equals(value)) {
                return true;
            }
            traverseNode.setNext(traverseNode.next.next);
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node traverseNode = head;
        int index = 0;
        while (traverseNode.next != null) {
            if (traverseNode.next.value.equals(value)) {
                return index;
            }
            index++;
            traverseNode = traverseNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        Node traverseNode = new Node(head.value, head.next);
        while (traverseNode.next != null) {
            traverseNode = traverseNode.next;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean remove(String value) {
        Node traverseNode = head;
        while (traverseNode.next != null) {
            if (traverseNode.next.value.equals(value)) {
                traverseNode.next = traverseNode.next.next;
                return true;
            }
            traverseNode = traverseNode.next;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        Node previousNode = findPreviousNode(index);
        String oldValue = previousNode.next.value;
        previousNode.next = previousNode.next.next;
        return oldValue;
    }

    private Node findPreviousNode(int index) {
        if (index == 0) {
            return head;
        }
        return findNodeByIndex(index - 1);
    }

    @Override
    public void clear() {
        head.next = null;
    }
}
