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
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void get() {
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
