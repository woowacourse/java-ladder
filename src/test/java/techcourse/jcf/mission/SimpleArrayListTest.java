package techcourse.jcf.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleArrayListTest {

    SimpleArrayList arrayList = new SimpleArrayList();

    @BeforeEach
    public void setUp() {
        arrayList = new SimpleArrayList();

        for (int i = 1; i <= 10; i++) {
            arrayList.add(String.valueOf(i));
        }
    }

    @Test
    void add() {
        arrayList.add("11");
        Assertions.assertEquals(11, arrayList.size());
    }

    @Test
    void addIndex() {
        arrayList.add(0, "test");

        Assertions.assertEquals("test", arrayList.get(0));
        Assertions.assertEquals("10", arrayList.get(10));
    }

    @Test
    void set() {
        arrayList.set(5, "test");
        Assertions.assertEquals("test", arrayList.get(5));
    }

    @Test
    void get() {
        Assertions.assertEquals("1", arrayList.get(0));
    }

    @Test
    void contains() {
        Assertions.assertTrue(arrayList.contains("5"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(1, arrayList.indexOf("2"));
    }

    @Test
    void size() {
        Assertions.assertEquals(10, arrayList.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(arrayList.isEmpty());
    }

    @Test
    void remove() {
        Assertions.assertTrue(arrayList.remove("1"));
        Assertions.assertEquals(9, arrayList.size());
    }

    @Test
    void removeIndex() {
        Assertions.assertEquals("1", arrayList.remove(0));
        Assertions.assertEquals(9, arrayList.size());
    }

    @Test
    void clear() {
        arrayList.clear();
        Assertions.assertEquals(0, arrayList.size());
    }
}
