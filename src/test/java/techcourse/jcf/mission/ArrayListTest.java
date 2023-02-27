package techcourse.jcf.mission;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {
    private static ArrayList arrayList;

    @BeforeAll
    static void setUp() {
        arrayList = new ArrayList();
    }

    @Test
    void add() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.size()).isEqualTo(3);
        assertThat(arrayList.get(0)).isEqualTo("a");
    }

    @Test
    void testAdd() {
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        assertThat(arrayList.size()).isEqualTo(2);
    }

    @Test
    void set() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.set(1, "d")).isEqualTo("b");
        assertThat(arrayList.get(1)).isEqualTo("d");
    }

    @Test
    void get() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.get(1)).isEqualTo("b");
    }

    @Test
    void contains() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.contains("b")).isTrue();
        assertThat(arrayList.contains("d")).isFalse();
    }

    @Test
    void indexOf() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.indexOf("b")).isEqualTo(1);
        assertThat(arrayList.indexOf("d")).isEqualTo(-1);
    }

    @Test
    void size() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.size()).isEqualTo(3);
    }

    @Test
    void isEmpty() {
        assertThat(arrayList.isEmpty()).isTrue();
        arrayList.add("a");
        assertThat(arrayList.isEmpty()).isFalse();
    }

    @Test
    void remove() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.remove("b")).isTrue();
        assertThat(arrayList.size()).isEqualTo(2);
        assertThat(arrayList.remove("d")).isFalse();
        assertThat(arrayList.size()).isEqualTo(2);
    }

    @Test
    void testRemove() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertThat(arrayList.remove(1)).isEqualTo("b");
        assertThat(arrayList.size()).isEqualTo(2);
    }

    @Test
    void clear() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.clear();
        assertThat(arrayList.size()).isEqualTo(0);
    }
}
