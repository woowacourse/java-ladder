package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    SimpleLinkedList simpleLinkedList;

    @BeforeEach
    void setUp() {
        simpleLinkedList = new SimpleLinkedList();
    }

    @Test
    void addIndexTest() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        simpleLinkedList.add(1, "inserted");
        String result1 = simpleLinkedList.get(0);
        String result2 = simpleLinkedList.get(1);
        String result3 = simpleLinkedList.get(2);

        assertAll(() -> assertThat(result1).isEqualTo("first")
                , () -> assertThat(result2).isEqualTo("inserted")
                , () -> assertThat(result3).isEqualTo("second"));
    }

    @Test
    void set() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        simpleLinkedList.set(1, "changed");
        String result1 = simpleLinkedList.get(0);
        String result2 = simpleLinkedList.get(1);
        String result3 = simpleLinkedList.get(2);

        assertAll(() -> assertThat(result1).isEqualTo("first")
                , () -> assertThat(result2).isEqualTo("changed")
                , () -> assertThat(result3).isEqualTo("third"));
    }

    @Test
    void get() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        String result = simpleLinkedList.get(2);

        assertThat(result).isEqualTo("third");
    }

    @Test
    void contains() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        boolean result = simpleLinkedList.contains("second");

        assertThat(result).isTrue();
    }

    @Test
    void indexOf() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        int index = simpleLinkedList.indexOf("second");

        assertThat(index).isEqualTo(1);
    }

    @Test
    void size() {

    }

    @Test
    void isEmpty() {
    }

    @Test
    void remove() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        String result1 = simpleLinkedList.remove(0);
        String result2 = simpleLinkedList.get(0);

        assertAll(() -> assertThat(result1).isEqualTo("first")
                , () -> assertThat(result2).isEqualTo("second"));
    }

    @Test
    void testRemove() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        simpleLinkedList.remove("first");
        String result2 = simpleLinkedList.get(0);

        assertThat(result2).isEqualTo("second");
    }

    @Test
    void clear() {
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.add("fourth");

        simpleLinkedList.clear();

        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }
}
