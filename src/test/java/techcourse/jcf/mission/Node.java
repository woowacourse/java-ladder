package techcourse.jcf.mission;

import java.util.Objects;

public class Node {
    private final String value;
    private Node nextNode;
    private Node prevNode;

    public Node(String value) {
        this(value, null, null);
    }

    public Node(String value, Node prevNode, Node nextNode) {
        this.value = value;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        if (prevNode != null) {
            prevNode.setNextNode(this);
        }
        if (nextNode != null) {
            nextNode.setPrevNode(this);
        }
    }

    public boolean hasNextNode() {
        return nextNode != null;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public void setPrevNode(Node node) {
        this.prevNode = node;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }


    public String getValue() {
        return value;
    }

    public boolean isValueMatch(String value) {
        return Objects.equals(this.value, value);
    }
}
