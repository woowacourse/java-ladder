package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SimpleArrayListTest {
    static SimpleArrayList values;

    @BeforeEach
    void beforeTest() {
        values = new SimpleArrayList();
        values.add("first");
        values.add("second");
    }

    @Test
    void add() {
        assertThat(values.add("third")).isTrue();
    }

    @Test
    void testAdd() {
        values.add(1, "firstPointFive");
        assertThat(values.get(1)).isEqualTo("firstPointFive");
    }

    @Test
    void set() {
        values.set(0, "modified First");
        assertThat(values.get(0)).isEqualTo("modified First");
    }

    @Test
    void get() {
        assertThat(values.get(1)).isEqualTo("second");
    }

    @Test
    void contains() {
        assertThat(values.contains("first")).isTrue();
        assertThat(values.contains("fourth")).isFalse();
    }

    @Test
    void indexOf() {
        assertThat(values.indexOf("second")).isEqualTo(1);
    }

    @Test
    void size() {
        values.add("third");
        assertThat(values.size()).isEqualTo(3);
    }

    @Test
    void isEmpty() {
        SimpleArrayList newValues = new SimpleArrayList();
        assertThat(newValues.isEmpty()).isTrue();
    }

    @Test
    void remove() {
        values.remove("first");
        assertThat(values.get(0)).isEqualTo("second");
    }

    @Test
    void testRemove() {
        values.add("third");
        values.remove(1);
        assertThat(values.get(1)).isEqualTo("third");
    }

    @Test
    void clear() {
        values.clear();
        assertThat(values.size()).isEqualTo(0);
    }
}
