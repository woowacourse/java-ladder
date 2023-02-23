package techcourse.jcf.mission;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SimpleArrayListTest {
    static List<String> original;
    static SimpleList simpleList;

    @BeforeAll
    static void setup() {
        original = new ArrayList<>(1);
        simpleList = new SimpleArrayList();
    }

    @Test
    void add() {
        original.add("first");
//        assertThatThrownBy(()->original.add(0, "first")).isInstanceOf(Exception.class);
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
        assertThat(original.size()).isEqualTo(0);
        original.add("first");
        assertThat(original.size()).isEqualTo(1);
        original.add("second");
        assertThat(original.size()).isEqualTo(2);
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
