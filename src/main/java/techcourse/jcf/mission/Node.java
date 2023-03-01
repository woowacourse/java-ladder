package techcourse.jcf.mission;

public class Node {
    private String value;
    private Node nextNode = null;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
    }

    public boolean isHavingNext() {
        return nextNode != null;
    }

    public Node getNext() {
        return nextNode;
    }

    public void addNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
