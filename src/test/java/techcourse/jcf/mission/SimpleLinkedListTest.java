package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void addList() {
        final SimpleLinkedList list = new SimpleLinkedList();

        list.add("홍실");

        Assertions.assertAll(
                () -> assertThat(list)
                        .extracting("size")
                        .isEqualTo(1),
                () -> assertThat(list.getStartNode().getValue())
                        .isEqualTo("홍실")
        );
    }

    @Test
    void addListAtIndex() {
        final String[] values = {"홍실", "다니"};
        final SimpleLinkedList list = new SimpleLinkedList(values);

        list.add(0, "썬샷");

        Assertions.assertAll(
                () -> assertThat(list.getStartNode().getValue())
                        .isEqualTo("썬샷"),
                () -> assertThat(list.getStartNode().getNext().getValue())
                        .isEqualTo("홍실")
        );
    }

    @Test
    void set() {

    }

    @Test
    void get() {
        final String[] values = {"홍실", "썬샷"};
        final SimpleLinkedList linkedList = new SimpleLinkedList(values);

        Assertions.assertAll(
                () -> assertThat(linkedList.get(0)).isEqualTo("홍실"),
                () -> assertThat(linkedList.get(1)).isEqualTo("썬샷")
        );
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }
}
