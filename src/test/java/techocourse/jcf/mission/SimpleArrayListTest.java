package techocourse.jcf.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleArrayListTest {

    SimpleArrayList simpleArrayList;

    @BeforeEach
    void init() {
        simpleArrayList = new SimpleArrayList();
    }

    @Test
    void add() {
        String input = "hello";

        simpleArrayList.add(input);

        assertThat(simpleArrayList.size()).isEqualTo(1);
    }

    @Test
    void addWithIndex() {
        String input = "hello";
        simpleArrayList.add(input);

        simpleArrayList.add(1, "world");

        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void get() {
        String input = "hello";
        simpleArrayList.add(input);

        assertThat(simpleArrayList.get(0)).isEqualTo(input);
    }

    @Test
    void set() {
        simpleArrayList.add("hello");
        String input = "hi";

        simpleArrayList.set(0, input);

        assertThat(simpleArrayList.get(0)).isEqualTo("hi");
    }

    @Test
    void contains() {
        String input = "hello";
        simpleArrayList.add(input);

        assertThat(simpleArrayList.contains(input)).isTrue();
    }

    @Test
    void indexOf() {
        String input1 = "hello";
        String input2 = "world";

        simpleArrayList.add(input1);
        simpleArrayList.add(input2);

        Assertions.assertAll(
                () -> assertThat(simpleArrayList.indexOf(input1)).isEqualTo(0),
                () -> assertThat(simpleArrayList.indexOf(input2)).isEqualTo(1)
        );
    }

    @Test
    void size() {
        String input1 = "hello";
        String input2 = "world";

        simpleArrayList.add(input1);
        simpleArrayList.add(input2);

        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void isEmptySuccess() {
        assertThat(simpleArrayList.isEmpty()).isTrue();
    }

    @Test
    void isEmptyFail() {
        String input = "hello";
        simpleArrayList.add(input);

        assertThat(simpleArrayList.isEmpty()).isFalse();
    }

    @Test
    void remove() {
        String input1 = "hello";
        String input2 = "world";

        simpleArrayList.add(input1);
        simpleArrayList.add(input2);

        assertThat(simpleArrayList.remove("hello")).isTrue();
    }

    @Test
    void removeWithIndex() {
        String input1 = "hello";
        String input2 = "world";

        simpleArrayList.add(input1);
        simpleArrayList.add(input2);

        assertThat(simpleArrayList.remove(1)).isEqualTo(input2);
    }

    @Test
    void clear() {
        String input1 = "hello";
        String input2 = "world";

        simpleArrayList.add(input1);
        simpleArrayList.add(input2);
        simpleArrayList.clear();

        assertThat(simpleArrayList.isEmpty()).isTrue();
    }
}
