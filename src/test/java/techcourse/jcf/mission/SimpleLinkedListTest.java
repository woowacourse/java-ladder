package techcourse.jcf.mission;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    private SimpleList list;

    @BeforeEach
    void setUp() {
        list = new SimpleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
    }

    @Test
    void add() {
        list.add("test");

        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("1", list.get(0));
        Assertions.assertEquals("2", list.get(1));
        Assertions.assertEquals("test", list.get(3));
    }

    @Test
    void addIndex() {
        list.add(1, "test");

        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("test", list.get(1));
    }

    @Test
    void set() {
        list.set(1, "test");

        Assertions.assertEquals("test", list.get(1));
    }

    @Test
    void get() {
        Assertions.assertEquals("2", list.get(1));
    }

    @Test
    void contains() {
        Assertions.assertTrue(list.contains("1"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(0, list.indexOf("1"));
    }

    @Test
    void size() {
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void remove() {
        list.remove("1");

        Assertions.assertEquals("2", list.get(0));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void removeIndex() {
        list.remove(0);

        Assertions.assertEquals("2", list.get(0));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void clear() {
        list.clear();

        Assertions.assertEquals(0, list.size());
    }
}