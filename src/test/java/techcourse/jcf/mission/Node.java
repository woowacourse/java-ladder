package techcourse.jcf.mission;

public class Node {

    public String value;
    public Node next;

    public Node(final String value, final Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(final String value) {
        this(value, null);
    }
}
