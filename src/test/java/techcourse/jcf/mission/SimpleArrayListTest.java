package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS )
public class SimpleArrayListTest {

    private SimpleArrayList simpleArrayList = new SimpleArrayList();

    @Test
    void add_string() {
        assertThat(simpleArrayList.add("first")).isTrue();
    }

    @Test
    void add_string_at_index(){
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add(0,"3");
        assertThat(simpleArrayList.get(1)).isEqualTo("1");
        assertThat(simpleArrayList.get(0)).isEqualTo("3");
    }

    @Test
    void set_string(){
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        simpleArrayList.set(3,"5");
        assertThat(simpleArrayList.get(3)).isEqualTo("5");
    }

    @Test
    void get_size(){
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        simpleArrayList.add("1");
        assertThat(simpleArrayList.size()).isEqualTo(4);
    }

    @Test
    void contains(){
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add("3");
        assertThat(simpleArrayList.contains("3")).isTrue();
        assertThat(simpleArrayList.contains("4")).isFalse();
    }
    @Test
    void empty(){
        assertThat(simpleArrayList.isEmpty()).isTrue();
        simpleArrayList.add("3");
        assertThat(simpleArrayList.isEmpty()).isFalse();
    }
    @Test
    void index_of() {
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add("4");
        simpleArrayList.add("0");
        assertThat(simpleArrayList.indexOf("4")).isEqualTo(2);
        assertThat(simpleArrayList.indexOf("5")).isEqualTo(-1);

    }

    @Test
    void remove(){
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add("4");
        assertThat(simpleArrayList.remove(1)).isEqualTo("2");
        assertThat(simpleArrayList.remove("1")).isTrue();
        simpleArrayList.print();
    }

}

