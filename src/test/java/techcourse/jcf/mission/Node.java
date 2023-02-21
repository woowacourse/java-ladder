package techcourse.jcf.mission;

import java.util.Objects;

public class Node {
    private final String value;
    private Node nextNode;

    public Node(String value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(String value, Node previousNode) {
        this.value = value;
        previousNode.setNextNode(this);
    }

    public boolean hasNextNode() {
        return nextNode != null;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public String getValue() {
        return value;
    }

    public boolean isValueMatch(String value) {
        return Objects.equals(this.value, value);
    }
}
