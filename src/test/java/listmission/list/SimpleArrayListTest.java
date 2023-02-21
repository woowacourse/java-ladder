package listmission.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void add() {
        SimpleList simpleArrayList = new SimpleArrayList();
        assertThat(simpleArrayList.add("first")).isTrue();
        assertThat(simpleArrayList.add("second")).isTrue();
    }

    @Test
    void addOverDefaultLength() {
        SimpleList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < 5; i++) {
            simpleArrayList.add("first");
            simpleArrayList.add("second");
        }

        simpleArrayList.add("last");
        assertThat(simpleArrayList.get(10)).isEqualTo("last");
        assertThat(simpleArrayList.size()).isEqualTo(11);
    }

    @Test
    void addNullValueTest() {
        SimpleList simpleArrayList = new SimpleArrayList();
        assertThatThrownBy(() -> simpleArrayList.add(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void addAtTest() {
        SimpleList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < 5; i++) {
            simpleArrayList.add("first");
            simpleArrayList.add("third");
        }

        simpleArrayList.add(1, "second");

        assertThat(simpleArrayList.get(1)).isEqualTo("second");
        assertThat(simpleArrayList.get(2)).isEqualTo("third");
        assertThat(simpleArrayList.size()).isEqualTo(11);
    }
    @Test
    void addAtFirstTest() {
        SimpleList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < 5; i++) {
            simpleArrayList.add("first");
            simpleArrayList.add("third");
        }

        simpleArrayList.add(0, "init");

        assertThat(simpleArrayList.get(0)).isEqualTo("init");
        assertThat(simpleArrayList.get(1)).isEqualTo("first");
        assertThat(simpleArrayList.size()).isEqualTo(11);
    }


    @Test
    void set() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        simpleArrayList.set(1, "세컨드");
        assertThat(simpleArrayList.get(1)).isEqualTo("세컨드");
    }

    @Test
    void get() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.get(0)).isEqualTo("first");
        assertThat(simpleArrayList.get(1)).isEqualTo("second");
    }

    @Test
    void getOutOfRange() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThatThrownBy(() -> simpleArrayList.get(5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void contains() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.contains("first")).isTrue();
        assertThat(simpleArrayList.contains("third")).isFalse();
    }

    @Test
    void indexOf() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.indexOf("first")).isEqualTo(0);
        assertThat(simpleArrayList.indexOf("second")).isEqualTo(1);
        assertThatThrownBy(() -> simpleArrayList.indexOf("third"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void size() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        SimpleList simpleArrayList = new SimpleArrayList();
        assertThat(simpleArrayList.isEmpty()).isTrue();
    }

    @Test
    void remove() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        simpleArrayList.remove(0);
        assertThat(simpleArrayList.get(0)).isEqualTo("second");
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void removeByValueTest() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("first");
        simpleArrayList.add("third");

        simpleArrayList.remove("first");
        simpleArrayList.remove("first");
        assertThat(simpleArrayList.get(0)).isEqualTo("second");
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void clear() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        simpleArrayList.clear();
        assertThat(simpleArrayList.size()).isEqualTo(0);
        assertThat(simpleArrayList.isEmpty()).isTrue();
    }
}
