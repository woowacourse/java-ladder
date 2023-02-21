package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    Node next;
    private int size;

    @Override
    public boolean add(String value) {
        Node newNode = new Node(value, null);
        if (next == null) {
            next = newNode;
            size++;
            return true;
        }
        Node tmp = next;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
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
        Node result = next;
        for (int i = 0; i < index; i++) {
            result = next.next;
        }
        return result.data;
    }

    @Override
    public boolean contains(String value) {
        Node result = next;
        while (result.next != null) {
            if (result.data.equals(value)) {
                return true;
            }
            result = next.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return this.size;
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
        String result;
        if (index == 0) {
            Node tmp = next;
            next = next.next;
            result = tmp.data;
            tmp = null;
        } else if (index == size - 1) {
            Node tmp = next;
            for (int i = 0; i < size; i++) {
                tmp = next.next;
            }
            result = tmp.data;
            tmp = null;
        } else {
            Node tmp = next;
            for (int i = 0; i < index - 1; i++) {
                tmp = next.next;
            }
            result = tmp.next.data;
            tmp.next = tmp.next.next;
        }
        size--;
        return result;
    }

    @Override
    public void clear() {

    }
}
