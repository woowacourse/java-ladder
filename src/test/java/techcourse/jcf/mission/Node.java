package techcourse.jcf.mission;

public class Node {

    Node prev;
    String item;
    Node next;

    public Node(Node prev, String item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
