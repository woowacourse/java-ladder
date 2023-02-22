package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void add() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        System.out.println("before add: " + simpleLinkedList);
        assertThat(simpleLinkedList.add("first")).isTrue();
        System.out.println("after add: " + simpleLinkedList);
        assertThat(simpleLinkedList.size()).isEqualTo(1);
    }

    @Test
    void set() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");

        System.out.println("before set: " + simpleLinkedList);
        assertThat(simpleLinkedList.set(0, "newFirst")).isEqualTo("first");
        System.out.println("after set: " + simpleLinkedList);
        assertThat(simpleLinkedList.get(0)).isEqualTo("newFirst");
    }

    @Test
    void get() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");

        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
    }

    @Test
    void contains() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");

        assertThat(simpleLinkedList.contains("first")).isTrue();
    }

    @Test
    void indexOf() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        assertThat(simpleLinkedList.indexOf("third")).isEqualTo(2);
    }

    @Test
    void size() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }

    @Test
    void isEmpty() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        assertThat(simpleLinkedList.isEmpty()).isTrue();
    }

    @Test
    void remove() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        System.out.println("before remove: " + simpleLinkedList);
        simpleLinkedList.remove("second");
        System.out.println("after remove: " + simpleLinkedList);
        
        assertThat(simpleLinkedList.size()).isEqualTo(2);
        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
        assertThat(simpleLinkedList.get(1)).isEqualTo("third");
        assertThat(simpleLinkedList.remove(1)).isEqualTo("third");
    }

    @Test
    void clear() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
        simpleLinkedList.add("third");

        simpleLinkedList.clear();
        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }
}
