package techcourse.jcf.mission;

public class Node {

    private final String value;
    private Node nextNode;

    public Node(String value){
        this.value = value;
        this.nextNode = null;
    }

    public void link(Node nextNode){
        this.nextNode = nextNode;
    }

    public String getValue(){
        return value;
    }

    public Node getNextNode(){
        return nextNode;
    }
}
