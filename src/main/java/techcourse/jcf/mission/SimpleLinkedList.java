package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private final Node head;

    public SimpleLinkedList() {
        this.head = new Node();
    }

    @Override
    public boolean add(String value) {
        checkNull(value);

        Node tmpNode = head;
        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
        }

        tmpNode.addNext(new Node(value));
        return true;
    }

    private void checkNull(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public void add(int index, String value) {
        checkNull(value);

        int nodeIndex = -1;
        Node tmpNode = head;
        while (nodeIndex < index) {
            if (nodeIndex + 1 == index) {
                Node originalNextNode = tmpNode.getNext();
                Node newNode = new Node(value);
                tmpNode.addNext(newNode);
                newNode.addNext(originalNextNode);
            }
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
        }
    }

    @Override
    public String set(int index, String value) {
        checkNull(value);
        checkBound(index);

        int nodeIndex = -1;
        String result = "";
        Node tmpNode = head;

        while (nodeIndex < index) {
            if (nodeIndex + 1 == index) {
                Node originalNextNode = tmpNode.getNext();
                result = originalNextNode.getValue();
                originalNextNode.setValue(value);
            }
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
        }

        return result;
    }

    private void checkBound(int index) {
        int nodeIndex = -1;
        Node tmpNode = head;
        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
        }
        if (nodeIndex < index) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String get(int index) {
        checkBound(index);
        int nodeIndex = -1;
        Node tmpNode = head;
        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
            if (nodeIndex == index) {
                return tmpNode.getValue();
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean contains(String value) {
        Node tmpNode = head;

        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
            String arrayValue = tmpNode.getValue();
            if (arrayValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        int nodeIndex = -1;
        Node tmpNode = head;

        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
            String arrayValue = tmpNode.getValue();
            nodeIndex += 1;
            if (arrayValue.equals(value)) {
                return nodeIndex;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        int nodeIndex = -1;
        Node tmpNode = head;
        while (tmpNode.isHavingNext()) {
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
        }
        return nodeIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return !head.isHavingNext();
    }

    @Override
    public boolean remove(String value) {
        checkNull(value);

        if (contains(value)) {
            Node tmpNode = head;

            while (tmpNode.isHavingNext()) {
                if (value.equals(tmpNode.getValue())) {
                    Node willRemoveNode = tmpNode.getNext();
                    Node nextNode = willRemoveNode.getNext();
                    tmpNode.addNext(nextNode);
                }
                tmpNode = tmpNode.getNext();
            }
            return true;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkBound(index);

        int nodeIndex = -1;
        String result = "";
        Node tmpNode = head;

        while (nodeIndex < index) {
            if (nodeIndex + 1 == index) {
                Node willRemoveNode = tmpNode.getNext();
                result = willRemoveNode.getValue();
                Node nextNode = willRemoveNode.getNext();
                tmpNode.addNext(nextNode);
            }
            tmpNode = tmpNode.getNext();
            nodeIndex += 1;
        }
        return result;
    }

    @Override
    public void clear() {
        head.addNext(null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node tmpNode = head;

        tmpNode = tmpNode.getNext();

        if (tmpNode == null) {
            return "{}";
        }

        stringBuilder.append("{");
        while (tmpNode.isHavingNext()) {
            stringBuilder.append(tmpNode.getValue()).append(", ");
            tmpNode = tmpNode.getNext();
        }

        stringBuilder.append(tmpNode.getValue()).append("}");
        return stringBuilder.toString();
    }
}
