package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {


    /*
    미션 2
    SimpleList 인터페이스의 LinkedList 구현체인 SimpleLinkedList 를 구현해본다.
    내부적으로 배열 없이 연결을 유지하여 동작을 이해하는 것을 목표로 한다.
    양방향으로 연결할 필요는 없다. 최대한 단순화하여 구현한다.
     */

    private Node head;
    private Node tail;
    private int size;

    public SimpleLinkedList() {
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node node = new Node(value);

        if(size == 0){
            head = node;
            tail = node;
            size++;
            return true;
        }

        tail.link(node);
        tail = node;
        return true;
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
