package techcourse.jcf.mission;

import java.util.Objects;

public class SimpleLinkedList implements SimpleList {

    private Node firstNode;

    private int size;

    public SimpleLinkedList() {
        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        Node iterator = firstNode;
        if (Objects.isNull(iterator)) {
            addFirstNode(new Node(value));
            return true;
        }
        for (; !iterator.isNextNull(); iterator = iterator.getNext())
            ;
        ++size;
        iterator.setNext(new Node(value));
        return true;
    }

    @Override
    public void add(int index, String value) {
        validateOutOfBound(index);
        if (size == 0 && index == 0) {
            addFirstNode(new Node(value));
            return;
        }
        Node beforeNode = firstNode;
        Node iterator = firstNode;
        nodeMovingDestination(beforeNode, iterator, index);
        nodeChaining(beforeNode, new Node(value), iterator);
        ++size;
    }

    private void nodeMovingDestination(Node before, Node iterator, Integer destination){
        for (int i = 0; i < destination; i++) {
            before = iterator;
            iterator = iterator.getNext();
        }
    }

    private void validateOutOfBound(int index) {
        if (!(0 <= index && index <= this.size)) {
            throw new IllegalArgumentException("인덱스는 범위를 벗어날 수 없습니다.");
        }
    }

    private void nodeChaining(Node first, Node second, Node third) {
        first.setNext(second);
        second.setNext(third);
    }

    private void addFirstNode(Node node) {
        if (!(size == 0 && Objects.isNull(firstNode))) {
            throw new IllegalStateException("초기 노드 추가 함수 호출이 잘못되었습니다.");
        }
        ++size;
        firstNode = node;
    }

    @Override
    public String set(int index, String value) {
        if (!(0 <= index && index < this.size)) {
            throw new IllegalArgumentException("인덱스는 범위를 벗어날 수 없습니다.");
        }
        Node iterator = firstNode;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
        }
        String oldValue = iterator.getValue();
        iterator.setValue(value);
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (!(0 <= index && index < this.size)) {
            throw new IllegalArgumentException("인덱스는 범위를 벗어날 수 없습니다.");
        }
        Node iterator = firstNode;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
        }
        return iterator.getValue();
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
