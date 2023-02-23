package techcourse.jcf.mission;

public class Node {
    private String value;
    private Node next;

    public Node(final String value, final Node next) {
        this.value = value;
        this.next = next;
    }

    public Node findLastNode() {
        if (this.next == null) {
            return this;
        }
        return this.findLastNode();
    }

    public void setNext(final Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
