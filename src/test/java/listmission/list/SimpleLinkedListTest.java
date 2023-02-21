package listmission.list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void add() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        assertThat(simpleArrayList.add("first")).isTrue();
        assertThat(simpleArrayList.add("second")).isTrue();
    }

    @Test
    void addAtTest() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        simpleArrayList.add("first");
        simpleArrayList.add("third");

        simpleArrayList.add(1, "second");

        assertThat(simpleArrayList.get(1)).isEqualTo("second");
    }

    @Test
    void set() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        simpleArrayList.set(0, "init");
        assertThat(simpleArrayList.get(0)).isEqualTo("init");
    }

    @Test
    void get() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.get(0)).isEqualTo("first");
        assertThat(simpleArrayList.get(1)).isEqualTo("second");
    }

    @Test
    void contains() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.contains("second")).isTrue();
        assertThat(simpleArrayList.contains("third")).isFalse();

    }

    @Test
    void indexOf() {
        SimpleList simpleArrayList = new SimpleLinkedList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        assertThat(simpleArrayList.indexOf("second")).isEqualTo(1);
    }

    @Test
    void size() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        assertThat(simpleLinkedList.size()).isEqualTo(3);
    }

    @Test
    void isEmpty() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        assertThat(simpleLinkedList.isEmpty()).isTrue();

        simpleLinkedList.add("first");
        assertThat(simpleLinkedList.isEmpty()).isFalse();
    }

    @Test
    void remove() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        String removedData = simpleLinkedList.remove(1);

        assertThat(removedData).isEqualTo("second");
        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
        assertThat(simpleLinkedList.get(1)).isEqualTo("third");

    }

    @Test
    void removeByValue() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        simpleLinkedList.remove("second");

        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
        assertThat(simpleLinkedList.get(1)).isEqualTo("third");
        assertThat(simpleLinkedList.size()).isEqualTo(2);
    }

    @Test
    void clear() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");
        simpleLinkedList.clear();

        assertThat(simpleLinkedList.isEmpty()).isTrue();
    }
}
