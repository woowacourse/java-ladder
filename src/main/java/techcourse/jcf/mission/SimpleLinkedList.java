package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {
    private int size = 0;
    private Node<String> first;
    private Node<String> last;

    SimpleLinkedList() {
    }

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    private void linkLast(String value) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, String value) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(value);
        else
            linkBefore(value, node(index));
    }

    private void linkBefore(String value, Node<String> succ) {
        final Node<String> pred = succ.prev;
        final Node<String> newNode = new Node<>(pred, value, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    private Node<String> node(int index) {
        Node<String> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("리스트 범위를 벗어난 인덱스입니다.");
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public String set(int index, String value) {
        checkElementIndex(index);
        Node<String> x = node(index);
        String oldValue = x.item;
        x.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("리스트 범위에 해당하지 않는 index 입니다.");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        if (value == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (value.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        if(value == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (value.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private String unlink(Node<String> x) {
        final String element = x.item;
        final Node<String> next = x.next;
        final Node<String> prev = x.prev;

        if(prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if(next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public void clear() {
        // clear를 수행하면서 노드 간 모든 링크들을 끊어주는 것은 불필요하다.
        // 하지만 버려진 노드들이 한 세대 이상 남아있게 된다면 generational GC를 도와주게 된다.
        // 하지만 해당 노드들에 접근 가능한 Iterator가 있다 하더라도 메모리를 해제를 보장한다.
        for (Node<String> x = first; x != null; ) {
            Node<String> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = null;
        }
        first = last = null;
        size = 0;
    }

    private static class Node<String> {
        String item;
        Node<String> next;
        Node<String> prev;

        Node(Node<String> prev, String element, Node<String> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
