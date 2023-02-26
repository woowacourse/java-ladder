package techcourse.jcf.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleLinkedList implements SimpleList {

    private Node pointer;
    private Node root;
    private int size;

    public SimpleLinkedList() {
        root = new Node("");
        pointer = root;
        size = 0;
    }

    @Override
    public boolean add(String value) {
        Node insertionNode = new Node(value);
        pointer.next = insertionNode;
        insertionNode.previous = pointer;
        pointer = insertionNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);
        int nodeIndex = 0;
        Node currentNode = root.next;

        while (nodeIndex != index) {
            currentNode = currentNode.next;
            nodeIndex++;
        }

        Node previousNode = currentNode.previous;
        Node insertionNode = new Node(value);
        currentNode.previous = insertionNode;
        previousNode.next = insertionNode;
        insertionNode.next = currentNode;
        insertionNode.previous = previousNode;
        size++;
    }

    @Override
    public String set(int index, String value) {
        validateIndex(index);
        int nodeIndex = 0;
        Node currentNode = root.next;

        while (nodeIndex != index) {
            currentNode = currentNode.next;
            nodeIndex++;
        }

        String indexValue = currentNode.value;
        currentNode.value = value;
        return indexValue;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        int nodeIndex = 0;
        Node currentNode = root.next;

        while (nodeIndex != index) {
            currentNode = currentNode.next;
            nodeIndex++;
        }

        return currentNode.value;
    }

    @Override
    public boolean contains(String value) {
        Node currentNode = root.next;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        Node currentNode = root.next;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                return index;
            }

            currentNode = currentNode.next;
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
        Node currentNode = root.next;

        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                removeNode(currentNode);
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        int nodeIndex = 0;
        Node currentNode = root.next;

        while (nodeIndex != index) {
            currentNode = currentNode.next;
            nodeIndex++;
        }

        removeNode(currentNode);
        return currentNode.value;
    }

    @Override
    public void clear() {
        root.next = null;
        pointer = root;
        size = 0;
    }

    private static class Node {
        String value;
        Node previous;
        Node next;

        Node(String value) {
            this.value = value;
            previous = null;
            next = null;
        }
    }

    private void removeNode(Node currentNode) {
        if (currentNode == pointer) {
            pointer = pointer.previous;
        }

        Node nextNode = currentNode.next;
        Node previous = currentNode.previous;
        if (nextNode != null) {
            nextNode.previous = previous;
        }
        previous.next = nextNode;
        size--;
    }

    private void validateIndex(int index) {
        if (!(0 <= index && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return String.format("[%s]", String.join(", ", makeResult()));
    }

    private String[] makeResult() {
        String[] result = new String[size];
        int index = 0;
        Node currentNode = root.next;

        while (currentNode != null) {
            result[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return result;
    }

}
