package minimission;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    SimpleList list;

    @BeforeEach
    void setUp() {
        list = new SimpleArrayList();

        list.add("first");
        list.add("second");
    }

    @Test
    void add() {
        Assertions.assertThat(list.get(0)).isEqualTo("first");
        Assertions.assertThat(list.get(1)).isEqualTo("second");
    }

    @Test
    void addWithIndex() {
        list.add(1, "middle");

        Assertions.assertThat(list.get(1)).isEqualTo("middle");
    }

    @Test
    void addWithIndex_fail() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(3, "fourth");
        });
    }

    @Test
    void set() {
        list.set(0, "zero");

        Assertions.assertThat(list.get(0)).isEqualTo("zero");
    }

    @Test
    void get_fail() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @Test
    void contains_success() {
        Assertions.assertThat(list.contains("first")).isTrue();
    }

    @Test
    void contains_fail() {
        Assertions.assertThat(list.contains("third")).isFalse();
    }

    @Test
    void indexOf_success() {
        Assertions.assertThat(list.indexOf("first")).isEqualTo(0);
    }

    @Test
    void indexOf_fail() {
        Assertions.assertThat(list.indexOf("third")).isEqualTo(-1);
    }

    @Test
    void size() {
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        Assertions.assertThat(list.isEmpty()).isFalse();
    }

    @Test
    void remove_index() {
        list.remove(0);

        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void remove_value() {
        list.remove("first");

        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void clear() {
        list.clear();

        Assertions.assertThat(list.size()).isEqualTo(0);
    }
}
