package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleLinkedTest {

    private SimpleLinkedList simple;

    @BeforeEach
    void beforeEach(){
        simple = new SimpleLinkedList();
    }

    @Test
    void add(){
        simple.add("first");
        Assertions.assertThat(simple.size()).isEqualTo(1);
    }

    @Test
    void add2(){
        simple.add("first");
        simple.add("second");
        simple.add(0,"zero");
        Assertions.assertThat(simple.get(0)).isEqualTo("zero");
        simple.add(simple.size()-1,"second");
        Assertions.assertThat(simple.get(simple.size()-1)).isEqualTo("second");
    }

    @Test
    void set(){
        simple.add("first");
        simple.set(0,"second");
        Assertions.assertThat(simple.get(0)).isEqualTo("second");
    }

    @Test
    void get(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        Assertions.assertThat(simple.get(2)).isEqualTo("third");
    }

    @Test
    void containsTest(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        Assertions.assertThat(simple.contains("third")).isTrue();
    }

    @Test
    void indexOfTest(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        Assertions.assertThat(simple.indexOf("third")).isEqualTo(2);
    }

    @Test
    void size(){
        simple.add("first");
        Assertions.assertThat(simple.size()).isEqualTo(1);
    }

    @Test
    void isEmptyTest(){
        Assertions.assertThat(simple.isEmpty()).isTrue();
    }

    @Test
    void remove(){
        simple.add("first");
        simple.add("second");
        simple.add("third");

        simple.remove("first");
        Assertions.assertThat(simple.get(0)).isEqualTo("second");

        simple.remove("third");
        Assertions.assertThat(simple.get(0)).isEqualTo("second");
    }

    @Test
    void removeIndexTest(){
        simple.add("first");
        simple.add("second");
        simple.add("third");

        simple.remove(0);

        Assertions.assertThat(simple.get(0)).isEqualTo("second");

        simple.remove(1);
        Assertions.assertThat(simple.get(0)).isEqualTo("second");
    }

    @Test
    void clear(){
        simple.add("first");
        simple.clear();
        Assertions.assertThat(simple.isEmpty()).isTrue();
    }
}
