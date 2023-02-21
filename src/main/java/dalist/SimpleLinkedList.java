package dalist;

public class SimpleLinkedList<T> implements SimpleList<T>{
    private final Node head;
    private int size;
    public  SimpleLinkedList(){
        this.head = new Node(null);
        size = 0;
    }
    @Override
    public boolean add(T value) {

        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        node.next = new Node(value);
        size++;
        return true;
    }

    @Override
    public void add(int index, T value) {
        Node node = findNodeWithIndex(index);
        Node nextNode = node.next;
        node.next = new Node(value);
        node.next.next = nextNode;
        size++;
    }
    private Node findNodeWithIndex(int index){
        int count = 0;
        Node node = head;
        while(count == index){
            node = node.next;
            count++;
            validateOutOfIndex(node);
        }
        return node;
    }
    private void validateOutOfIndex(Node node) {
        if(node == null){
            throw new ArrayIndexOutOfBoundsException("");
        }
    }

    @Override
    public T set(int index, T value) {
        if(index == 0){
            Node nextNode = head.next;
            head.next = new Node(value);
            head.next.next = nextNode;
            return nextNode.value;
        }
        Node preNode = findNodeWithIndex(index-1);
        T returnValue = preNode.next.value;
        Node nextNode = preNode.next.next;
        preNode.next = new Node(value);
        preNode.next.next = nextNode;
        return returnValue;
    }

    @Override
    public T get(int index) {
        return findNodeWithIndex(index).value;
    }

    @Override
    public boolean contains(T value) {
        Node node = head;
        while(node.next!=null){
            if(node.value.equals(value)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node node = head;
        int index=-1;
        while(node.next!=null){
            if(node.value.equals(value)){
                return index;
            }
            index++;
            node =node.next;
        }
        return index;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean remove(T value) {
        Node preNode = null;
        Node now = head;
        while(now.next != null){
            if(now.value.equals(value)){
                preNode.next = now.next;
                size--;
                return true;
            }
            preNode = now;
            now = now.next;
        }
        throw new NullPointerException("");
    }

    @Override
    public T remove(int index) {
        if(size>=index||index<0){
            throw new ArrayIndexOutOfBoundsException("");
        }
        Node preNode = null;
        Node now = head;
        int count = 0;
        while(now.next!=null){
            if(count==index){
                preNode.next = now.next;
                size--;
                return now.value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.size = 0;
    }
    private class Node{
        private Node next = null;
        private final T value;
        protected Node(T value){
            this.value = value;
        }
        protected void setNext(Node next){
            this.next = next;
        }
    }
}
