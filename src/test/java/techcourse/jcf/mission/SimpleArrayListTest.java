package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void add() {
        SimpleArrayList simpleArrayList = new SimpleArrayList();

        System.out.println("before add: " + simpleArrayList);
        assertThat(simpleArrayList.add("first")).isTrue();
        System.out.println("after add: " + simpleArrayList);

        simpleArrayList.add(0, "newFirst");
        System.out.println("after addByIndex: " + simpleArrayList);

        assertThatThrownBy(() -> simpleArrayList.add(-1, "fail"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void set() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second", "third"});

        System.out.println("before set: " + simpleArrayList);
        assertThat(simpleArrayList.set(1, "newSecond")).isEqualTo("second");
        System.out.println("after set: " + simpleArrayList);

        assertThatThrownBy(() -> simpleArrayList.set(-1, "fail"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void get() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second"});

        assertThat(simpleArrayList.get(0)).isEqualTo("first");
    }

    @Test
    void contains() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second"});

        assertThat(simpleArrayList.contains("first")).isTrue();
        assertThat(simpleArrayList.contains("none")).isFalse();
    }

    @Test
    void indexOf() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second"});

        assertThat(simpleArrayList.indexOf("first")).isEqualTo(0);
        assertThat(simpleArrayList.indexOf("second")).isEqualTo(1);
        assertThat(simpleArrayList.indexOf("none")).isEqualTo(-1);
    }

    @Test
    void isEmpty() {
        SimpleArrayList simpleArrayList = new SimpleArrayList();

        assertThat(simpleArrayList.isEmpty()).isTrue();
    }

    @Test
    void remove() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second"});

        assertThat(simpleArrayList.remove("first")).isTrue();
        assertThat(simpleArrayList.remove("none")).isFalse();
        assertThat(simpleArrayList.remove(0)).isEqualTo("second");
    }

    @Test
    void clear() {
        SimpleArrayList simpleArrayList = new SimpleArrayList(new String[]{"first", "second"});
        simpleArrayList.clear();

        assertThat(simpleArrayList.isEmpty()).isTrue();
    }
}
