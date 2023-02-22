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
        size++;
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
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.getNextNode();
        }
        return node.getValue();
    }

    @Override
    public boolean contains(String value) {
        if(isEmpty()){
            return false;
        }

        Node node = head;
        for(int i = 0; i < size; i++){
            if(node.getValue().equals(value)){
                return true;
            }
            node = node.getNextNode();
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        if(isEmpty()){
            return -1;
        }

        Node node = head;
        for(int i = 0; i < size; i++){
            if(node.getValue().equals(value)){
                return i;
            }
            node = node.getNextNode();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
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
        size = 0;
    }
}
