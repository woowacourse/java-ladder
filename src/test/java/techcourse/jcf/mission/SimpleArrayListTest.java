package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    private SimpleList arrayList;

    @BeforeEach
    public void setUp() {
        arrayList = new SimpleArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(String.valueOf(i));
        }
    }

    @Test
    void addValue() {
        arrayList.add("11");
        assertEquals(11, arrayList.size());
    }

    @Test
    void addValueByIndex() {
        arrayList.add(0, "test");

        assertEquals("test", arrayList.get(0));
        assertEquals("10", arrayList.get(10));
        assertEquals(11, arrayList.size());
    }

    @Test
    void addValueIndexOutOfRange() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(10, "test"));
    }

    @Test
    void setValueByIndex() {
        arrayList.set(5, "test");

        assertEquals("test", arrayList.get(5));
    }

    @Test
    void get() {
        assertEquals("1", arrayList.get(0));
    }

    @Test
    void contains() {
        assertTrue(arrayList.contains("5"));
    }

    @Test
    void indexOf() {
        assertEquals(1, arrayList.indexOf("2"));
    }

    @Test
    void size() {
        assertEquals(10, arrayList.size());
    }

    @Test
    void isEmpty() {
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void remove() {
        assertTrue(arrayList.remove("1"));
        assertEquals(9, arrayList.size());
    }

    @Test
    void removeIndex() {
        assertEquals("1", arrayList.remove(0));
        assertEquals(9, arrayList.size());
    }

    @Test
    void clear() {
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }
}