package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleArrayListTest {

    private SimpleArrayList simple;

    @BeforeEach
    void beforeEach(){
        simple = new SimpleArrayList();
    }

    @Test
    void add(){
        simple.add("first");
        Assertions.assertThat(simple.get(0)).isEqualTo("first");
    }

    @Test
    void addValue(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        simple.add(0,"zero");

        Assertions.assertThat(simple.get(0)).isEqualTo("zero");
    }

    @Test
    void set(){
        simple.add("first");
        simple.add("third");
        simple.set(1,"second");
        Assertions.assertThat(simple.get(1)).isEqualTo("second");
    }

    @Test
    void get(){
        simple.add("first");
        Assertions.assertThat(simple.get(0)).isEqualTo("first");
    }

    @Test
    void contains(){
        simple.add("first");
        Assertions.assertThat(simple.contains("first")).isEqualTo(true);
    }

    @Test
    void indexOf(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        Assertions.assertThat(simple.indexOf("first")).isEqualTo(0);
    }

    @Test
    void size(){
        Assertions.assertThat(simple.size()).isEqualTo(0);
    }

    @Test
    void isEmpty(){
        Assertions.assertThat(simple.isEmpty()).isTrue();
    }

    @Test
    void remove(){
        simple.add("first");
        simple.remove("first");
        Assertions.assertThat(simple.size()).isEqualTo(0);
    }

    @Test
    void removeIndex(){
        simple.add("first");
        simple.add("second");
        simple.add("third");
        simple.remove(1);
        Assertions.assertThat(simple.size()).isEqualTo(2);
    }

    @Test
    void clear(){
        simple.add("first");
        simple.clear();
        Assertions.assertThat(simple.isEmpty()).isTrue();
    }
}
