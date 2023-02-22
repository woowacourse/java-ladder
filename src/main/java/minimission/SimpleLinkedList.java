package minimission;

import java.util.StringJoiner;

public class SimpleLinkedList implements SimpleList {

    private Node startNode;
    private Node currentNode;

    public SimpleLinkedList() {
        startNode = null;
        currentNode = null;
    }

    public boolean add(String value) {
        Node node = makeNewNode(value);

        if (startNode == null) {
            startNode = node;
            currentNode = node;
            return true;
        }
        currentNode.next = node;
        currentNode = node;
        return true;
    }

    public void add(int index, String value) {
        Node newNode = makeNewNode(value);

        if (index == 0) {
            newNode.next = startNode;
            startNode = newNode;
            return;
        }

        Node indexNode = startNode;
        Node beforeNode = startNode;

        for (int i = 0; i < index; i++) {
            beforeNode = indexNode;
            indexNode = indexNode.next;
        }
        beforeNode.next = newNode;
        newNode.next = indexNode;
    }

    private Node makeNewNode(String value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        return node;
    }

    public String set(int index, String value) {
        Node indexNode = startNode;
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.next;
        }

        String beforeValue = indexNode.value;
        indexNode.value = value;
        return beforeValue;
    }

    public String get(int index) {
        Node indexNode = startNode;
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.next;
        }

        return indexNode.value;
    }

    public boolean contains(String value) {
        Node indexNode = startNode;

        while (indexNode != null) {
            if (indexNode.value.equals(value)) {
                return true;
            }
            indexNode = indexNode.next;
        }
        return false;
    }

    public int indexOf(String value) {
        Node indexNode = startNode;
        int index = 0;

        while (!indexNode.value.equals(value)) {
            index++;
            indexNode = indexNode.next;
        }
        return index;
    }

    public int size() {
        return indexOf(currentNode.value) + 1;
    }

    public boolean isEmpty() {
        return startNode == null;
    }

    public boolean remove(String value) {
        Node indexNode = startNode;

        Node beforeNode = startNode;
        while (!indexNode.value.equals(value)) {
            beforeNode = indexNode;
            indexNode = indexNode.next;
        }

        if (indexNode == startNode) {
            startNode = null;
            return true;
        }

        beforeNode.next = indexNode.next;
        return true;
    }

    public String remove(int index) {
        Node indexNode = startNode;
        Node beforeNode = startNode;
        for (int i = 0; i < index; i++) {
            beforeNode = indexNode;
            indexNode = indexNode.next;
        }
        String beforeValue = indexNode.value;
        if (indexNode == startNode) {
            startNode = startNode.next;
            return beforeValue;
        }

        beforeNode.next = indexNode.next;
        return beforeValue;
    }

    public void clear() {
        startNode = null;
        currentNode = null;
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        Node indexNode = startNode;

        while (indexNode != null) {
            result.add(indexNode.value);
            indexNode = indexNode.next;
        }
        return result.toString();
    }

    static class Node {
        public Node next;
        public String value;
    }
}
