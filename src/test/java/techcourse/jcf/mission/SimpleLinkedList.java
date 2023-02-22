package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private SimpleElement head;
    private int index = 0;

    @Override
    public boolean add(String value) {
        SimpleElement newElement = new SimpleElement(value);

        if (head == null) {
            head = newElement;
            this.index++;
            return true;
        }

        processAddElement(newElement);
        this.index++;
        return true;
    }

    private void processAddElement(SimpleElement newElement) {
        SimpleElement target = head;

        while (target.hasNext()) {
            target = target.getNext();
        }

        target.setNext(newElement);
    }

    @Override
    public void add(int index, String value) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }

        SimpleElement target = findTargetElement();
        SimpleElement newElement = new SimpleElement(value);
        target.setNext(newElement);
        this.index++;
    }

    private SimpleElement findTargetElement() {
        int position = 0;
        SimpleElement target = head;

        while (position++ < index) {
            target = head.getNext();
        }

        return target;
    }

    @Override
    public String set(int index, String value) {
        SimpleElement before = findTargetElement(index - 1);
        SimpleElement target = before.getNext();
        String temp = target.getValue();
        SimpleElement newElement = new SimpleElement(value);
        SimpleElement next = target.getNext();

        newElement.setNext(next);
        before.setNext(newElement);
        return temp;
    }

    @Override
    public String get(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        SimpleElement target = findTargetElement(index);

        return target.getValue();
    }

    private SimpleElement findTargetElement(int index) {
        int position = 0;
        SimpleElement target = head;

        while (position++ < index) {
            target = head.getNext();
        }

        return target;
    }

    @Override
    public boolean contains(String value) {
        if (head.getValue().equals(value)) {
            return true;
        }

        SimpleElement target = head;

        while (target.hasNext()) {
            target = target.getNext();
            if (target.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(String value) {
        int position = 0;

        SimpleElement target = head;

        if (target.getValue().equals(value)) {
            return position;
        }

        while (target.hasNext()) {
            target = target.getNext();
            position++;
            if (target.getValue().equals(value)) {
                return position;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index != 0;
    }

    @Override
    public boolean remove(String value) {
        SimpleElement target = head;

        if (target.getValue().equals(value)) {
            SimpleElement validElement = target.getNext();
            this.head = validElement;
            this.index--;
            return true;
        }

        SimpleElement before = null;
        while (target.hasNext()) {
            before = target;
            target = target.getNext();
            if (target.getValue().equals(value)) {
                SimpleElement validElement = target.getNext();
                before.setNext(validElement);
                this.index--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.index--;

        if (index == 0) {
            return processFirstIndexRemove();
        }
        return processRemove(index);
    }

    private String processFirstIndexRemove() {
        String temp = head.getValue();

        head = head.getNext();
        return temp;
    }

    private String processRemove(int index) {
        SimpleElement before = findTargetElement(index - 1);
        SimpleElement target = before.getNext();
        String temp = target.getValue();

        target = target.getNext();
        before.setNext(target);
        return temp;
    }

    @Override
    public void clear() {
        SimpleElement target = head;
        SimpleElement temp = null;

        while (target.hasNext()) {
            temp = target;
            target = target.getNext();
            temp = null;
        }

        this.index = 0;
    }
}
