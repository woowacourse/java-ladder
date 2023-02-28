package techcourse.icf.mission;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private int size;

    private class Node {

        private String data; //데이터 저장 변수
        private Node link;  //다른 노드를 참조

        public Node(String value) {
            data = value;
            link = null;
        }

        public Node(String value, Node next) {
            data = value;
            link = next;
        }

        public String getData() {
            return data;
        }

        public Node getLink() {
            return link;
        }

        public void setData(String value) {
            data = value;
        }

        public void setLink(Node node) {
            link = node;
        }
    }

    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    private Node getNode(int index) {
        Node currentNode = head;
        for (int i = 0; currentNode != null; i++) {
            if (i == index) {
                return currentNode;
            }
            currentNode = currentNode.getLink();
        }
        return null;
    }

    @Override
    public boolean add(String value) {
        if (size == 0) {
            head = new Node(value);
            size += 1;
            return true;
        }
        Node prev = getNode(size - 1);
        add(prev, value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        add(getNode(index - 1), value);
    }

    private void add(Node prev, String value) {
        Node newNode = new Node(value);
        newNode.setLink(prev.getLink());
        prev.setLink(newNode);
        size += 1;
    }

    @Override
    public String set(int index, String value) {
        getNode(index).setData(value);
        return value;
    }

    @Override
    public String get(int index) {
        return getNode(index).getData();
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(String value) {
        Node currentNode = head;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.getData() == value) {
                return i;
            }
            currentNode = currentNode.getLink();
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

    private String remove(Node prevNode, Node node) {
        if (node == null || size == 0) {
            return null;
        }
        if (node != null && prevNode == null) {
            head = node.getLink();
            size = size - 1;
            return node.getData();
        }
        prevNode.setLink(node.getLink());
        size = size - 1;
        return node.getData();

    }

    @Override
    public boolean remove(String value) {
        Node target = getNode(indexOf(value));
        Node prev = getNode(indexOf(value) - 1);
        return remove(prev, target) != null;
    }

    @Override
    public String remove(int index) {
        Node target = getNode(index);
        Node prev = getNode(index - 1);
        return remove(prev, target);
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }
}
