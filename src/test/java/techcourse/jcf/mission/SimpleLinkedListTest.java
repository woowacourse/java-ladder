package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

    @BeforeEach
    void setUp() {
        simpleLinkedList = new SimpleLinkedList();
    }

    @Test
    void add() {
        // given
        simpleLinkedList.add("glen");

        // when
        String result = simpleLinkedList.get(0);

        // then
        assertThat(result)
                .isEqualTo("glen");
    }

    @Test
    void add2() {
        // given
        simpleLinkedList.add("glen");
        simpleLinkedList.add(0, "doggy");

        // when
        String result = simpleLinkedList.get(0);

        // then
        assertThat(result)
                .isEqualTo("doggy");
    }

    @Test
    void set() {
        // given
        simpleLinkedList.add("glen");
        simpleLinkedList.set(0, "doggy");

        // when
        String result = simpleLinkedList.get(0);

        // then
        assertThat(result)
                .isEqualTo("doggy");
    }

    @Test
    void contains() {
        // given
        simpleLinkedList.add("glen");

        // expect
        assertThat(simpleLinkedList.contains("glen"))
                .isTrue();
        assertThat(simpleLinkedList.contains("doggy"))
                .isFalse();
    }

    @Test
    void indexOf() {
        // given
        simpleLinkedList.add("glen");
        simpleLinkedList.add("doggy");

        // expect
        assertThat(simpleLinkedList.indexOf("glen"))
                .isEqualTo(0);
        assertThat(simpleLinkedList.indexOf("doggy"))
                .isEqualTo(1);
        assertThat(simpleLinkedList.indexOf("pobi"))
                .isEqualTo(-1);
    }

    @Test
    void size() {
        // given
        simpleLinkedList.add("glen");
        simpleLinkedList.add("doggy");

        // expect
        assertThat(simpleLinkedList.size())
                .isEqualTo(2);
    }

    @Test
    void isEmpty() {
        // expect
        assertThat(simpleLinkedList.isEmpty())
                .isTrue();

        simpleLinkedList.add("glen");

        assertThat(simpleLinkedList.isEmpty())
                .isFalse();
    }

    @Test
    void remove() {
        // given
        simpleLinkedList.add("glen");
        simpleLinkedList.add("pobi");
        simpleLinkedList.add("player");

        // when
        simpleLinkedList.remove("pobi");

        // then
        assertThat(simpleLinkedList.indexOf("pobi"))
                .isEqualTo(-1);
    }

    @Test
    void remove2() {
        // given
        simpleLinkedList.add("glen");

        // when
        simpleLinkedList.remove(0);

        // then
        assertThat(simpleLinkedList.indexOf("glen"))
                .isEqualTo(-1);
    }

    @Test
    void clear() {
        // given
        simpleLinkedList.add("glen");

        // when
        simpleLinkedList.clear();

        // then
        assertThat(simpleLinkedList.isEmpty())
                .isTrue();
    }
}
