package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void ADD_실행시_노드_추가() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        Assertions.assertThat(simpleList.size()).isEqualTo(1);
    }

    @Test
    void get_실행시_value_반환() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        simpleList.add("park");
        Assertions.assertThat(simpleList.get(2)).isEqualTo("park");
    }

    @Test
    void 특정_인덱스에_add() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        simpleList.add("park");
        simpleList.add(2,"jang");
        Assertions.assertThat(simpleList.get(2)).isEqualTo("jang");
    }

    @Test
    void 특정_인덱스_set() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.set(0,"kim");
        Assertions.assertThat(simpleList.get(0)).isEqualTo("kim");
    }

    @Test
    void contains() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        Assertions.assertThat(simpleList.contains("kim")).isTrue();

    }

    @Test
    void indexOf() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        Assertions.assertThat(simpleList.indexOf("kim")).isEqualTo(1);
    }

    @Test
    void isEmpty() {

    }

    @Test
    void remove() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        simpleList.add("park");
        simpleList.remove("lee");
        Assertions.assertThat(simpleList.get(0)).isEqualTo("kim");
    }

    @Test
    void remove2() {
        SimpleList simpleList = new SimpleLinkedList();
        simpleList.add("lee");
        simpleList.add("kim");
        simpleList.add("park");
        simpleList.remove(0);
        Assertions.assertThat(simpleList.get(0)).isEqualTo("kim");
    }
}
