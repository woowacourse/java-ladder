package minimission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    SimpleList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new SimpleLinkedList();

        linkedList.add("node0");
        linkedList.add("node1");
        linkedList.add("node2");
        linkedList.add("node3");
    }

    @Test
    void add_index() {
        linkedList.add(1, "node0-1");

        assertThat(linkedList.size()).isEqualTo(5);
        assertThat(linkedList.get(0)).isEqualTo("node0");
        assertThat(linkedList.get(1)).isEqualTo("node0-1");
        assertThat(linkedList.get(2)).isEqualTo("node1");
    }

    @Test
    void set() {
        linkedList.set(2, "modifiedNode2");

        assertThat(linkedList.get(2)).isEqualTo("modifiedNode2");
    }

    @Test
    void contains() {
        assertThat(linkedList.contains("node2")).isTrue();
        assertThat(linkedList.contains("node4")).isFalse();
    }

    @Test
    void indexOf() {
        assertThat(linkedList.indexOf("node1")).isEqualTo(1);
    }

    @Test
    void isEmpty() {
        assertThat(linkedList.isEmpty()).isFalse();
    }

    @Test
    void remove_value() {
        linkedList.remove("node1");

        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(0)).isEqualTo("node0");
        assertThat(linkedList.get(1)).isEqualTo("node2");
    }

    @Test
    void remove_index() {
        linkedList.remove(2);

        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo("node1");
        assertThat(linkedList.get(2)).isEqualTo("node3");
    }

    @Test
    void clear() {
        linkedList.clear();
        assertThat(linkedList.isEmpty()).isTrue();
    }
}
