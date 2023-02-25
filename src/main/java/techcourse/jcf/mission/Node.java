package techcourse.jcf.mission;

public class Node {

    private final String value;
    private Node nextNode;
    private Node prevNode;

    public Node(String value) {
        this.value = value;
        this.nextNode = null;
    }

    public String getValue() {
        return value;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node nextNode() {
        return nextNode;
    }

    public Node prevNode() {
        return prevNode;
    }
}
