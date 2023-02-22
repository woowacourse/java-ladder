package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

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
        list.add("4");
        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "1");
        assertEquals(list.get(3), "4");
    }

    @Test
    void addWithIndex() {
        list.add(1, "test");

        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "1");
        assertEquals(list.get(1), "test");
        assertEquals(list.get(2), "2");
        assertEquals(list.get(3), "3");
    }

    @Test
    void set() {
        list.set(1, "test");

        assertEquals(list.size(), 3);
        assertEquals(list.get(0), "1");
        assertEquals(list.get(1), "test");
        assertEquals(list.get(2), "3");
    }

    @Test
    void get() {
        assertEquals(list.get(0), "1");
    }

    @Test
    void contains() {
        assertTrue(list.contains("1"));
        assertFalse(list.contains("0"));
    }

    @Test
    void indexOf() {

        assertEquals(list.indexOf("2"), 1);
    }

    @Test
    void size() {
        assertEquals(list.size(), 3);
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    void remove() {
        assertTrue(list.remove("2"));
        assertEquals(list.size(), 2);
        assertEquals(list.get(1), "3");
    }

    @Test
    void removeByIndex() {
        assertEquals(list.remove(1), "2");
        assertEquals(list.size(), 2);
        assertEquals(list.get(1), "3");
    }

    @Test
    void clear() {
        list.clear();

        assertEquals(list.size(), 0);
    }
}