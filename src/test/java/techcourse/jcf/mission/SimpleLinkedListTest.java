package techcourse.jcf.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleLinkedListTest {

    private SimpleLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SimpleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
    }

    @Test
    void add() {
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(1), "2");
    }

    @Test
    void addIndex() {
        list.add(1, "test");
        Assertions.assertEquals(list.size(), 4);
        Assertions.assertEquals(list.get(0), "1");
        Assertions.assertEquals(list.get(1), "test");
        Assertions.assertEquals(list.get(2), "2");
        Assertions.assertEquals(list.get(3), "3");
    }

    @Test
    void set() {
        list.set(1, "test");
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(0), "1");
        Assertions.assertEquals(list.get(1), "test");
        Assertions.assertEquals(list.get(2), "3");
    }

    @Test
    void get() {
        Assertions.assertEquals(list.get(0), "1");
        Assertions.assertEquals(list.get(1), "2");
        Assertions.assertEquals(list.get(2), "3");
    }

    @Test
    void contains() {
        Assertions.assertTrue(list.contains("2"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(list.indexOf("1"), 0);
    }

    @Test
    void size() {
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void remove() {
        Assertions.assertTrue(list.remove("2"));
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertEquals(list.get(0), "1");
        Assertions.assertEquals(list.get(1), "3");
    }

    @Test
    void removeIndex() {
        Assertions.assertEquals(list.remove(1), "2");
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertEquals(list.get(0), "1");
        Assertions.assertEquals(list.get(1), "3");
    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertEquals(list.size(), 0);
    }
}
