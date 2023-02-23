package techcourse.jcf.mission;

import java.util.Optional;

public class SimpleLinkedList implements SimpleList {
    private int index;
    private String value;
    private SimpleLinkedList next;

    public SimpleLinkedList() {
    }

    @Override
    public boolean add(String value) {
        if (checkRootLinkEmpty()) {
            this.value = value;
            return true;
        }

        SimpleLinkedList currentLink = this;
        while (checkNotEmpty(currentLink.next)) {
            currentLink = currentLink.next;
        }
        currentLink.next = new SimpleLinkedList();
        currentLink.next.index = currentLink.index + 1;
        currentLink.next.value = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        SimpleLinkedList beforeLink = findLinkAt(index - 1);

        if (checkEmpty(beforeLink.next)) {
            beforeLink.next = new SimpleLinkedList();
            beforeLink.next.index = beforeLink.index + 1;
            beforeLink.next.value = value;
            return;
        }

        final SimpleLinkedList targetLink = beforeLink.next;
        final SimpleLinkedList newLink = new SimpleLinkedList();
        beforeLink.next = newLink;
        newLink.next = targetLink;
        newLink.index = targetLink.index;
        newLink.value = value;

        SimpleLinkedList afterLink = targetLink;
        while (checkNotEmpty(afterLink)) {
            afterLink.index++;
            afterLink = afterLink.next;
        }
    }

    @Override
    public String set(int index, String value) {
        return findLinkAt(index).value = value;
    }

    @Override
    public String get(int index) {
        return findLinkAt(index).value;
    }

    @Override
    public boolean contains(String value) {
        SimpleLinkedList currentLink = this;
        while (checkNotEmpty(currentLink)) {
            if (currentLink.value.equals(value)) {
                return true;
            }
            currentLink = currentLink.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        SimpleLinkedList currentLink = this;
        while (!currentLink.value.equals(value)) {
            validateNotExists(currentLink.next);
            currentLink = currentLink.next;
        }
        return currentLink.index;
    }

    @Override
    public int size() {
        if (checkEmpty(value)) {
            return 0;
        }

        SimpleLinkedList currentLink = this;
        while (checkNotEmpty(currentLink.next)) {
            currentLink = currentLink.next;
        }
        return currentLink.index + 1;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public boolean remove(String value) {
        SimpleLinkedList beforeLink = this;
        SimpleLinkedList currentLink = this;
        while (!currentLink.value.equals(value)) {
            if (checkEmpty(currentLink.next)) {
                return false;
            }
            beforeLink = currentLink;
            currentLink = currentLink.next;
        }

        beforeLink.next = currentLink.next;
        while (checkNotEmpty(currentLink.next)) {
            currentLink = currentLink.next;
            currentLink.index--;
        }

        return true;
    }

    @Override
    public String remove(int index) {
        validateOutOfRange(value);
        SimpleLinkedList currentLink = findLinkAt(index);

        final String removedValue = currentLink.value;
        while (checkNotEmpty(currentLink.next)) {
            currentLink = currentLink.next;
            currentLink.index--;
        }
        return removedValue;
    }

    @Override
    public void clear() {
        value = null;
        next = null;
    }

    private SimpleLinkedList findLinkAt(int index) {
        SimpleLinkedList currentLink = this;
        while (currentLink.index != index) {
            validateOutOfRange(currentLink.next);
            currentLink = currentLink.next;
        }
        return currentLink;
    }

    private boolean checkRootLinkEmpty() {
        return this.index == 0 && this.value == null;
    }

    private <T> boolean checkEmpty(T t) {
        return Optional.ofNullable(t).isEmpty();
    }

    private <T> boolean checkNotEmpty(T t) {
        return Optional.ofNullable(t).isPresent();
    }

    private <T> void validateOutOfRange(T t) {
        Optional.ofNullable(t).orElseThrow(() -> new IndexOutOfBoundsException("존재하는 인덱스 범위를 넘을 수 없습니다."));
    }

    private <T> void validateNotExists(T t) {
        Optional.ofNullable(t).orElseThrow(() -> new NullPointerException("존재하지 않는 값입니다."));
    }
}
