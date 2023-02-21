package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    SimpleArrayList simpleArrayList = new SimpleArrayList();

    @BeforeEach
    void setUp() {
        simpleArrayList = new SimpleArrayList();
    }

    @Test
    void add() {
        // given
        simpleArrayList.add("glen");

        // when
        String result = simpleArrayList.get(0);

        // then
        assertThat(result)
                .isEqualTo("glen");
    }

    @Test
    void add2() {
        // given
        simpleArrayList.add("glen");
        simpleArrayList.add(0, "doggy");

        // when
        String result = simpleArrayList.get(0);

        // then
        assertThat(result)
                .isEqualTo("doggy");
    }

    @Test
    void set() {
        // given
        simpleArrayList.add("glen");
        simpleArrayList.set(0, "doggy");

        // when
        String result = simpleArrayList.get(0);

        // then
        assertThat(result)
                .isEqualTo("doggy");
    }

    @Test
    void contains() {
        // given
        simpleArrayList.add("glen");

        // expect
        assertThat(simpleArrayList.contains("glen"))
                .isTrue();
        assertThat(simpleArrayList.contains("doggy"))
                .isFalse();
    }

    @Test
    void indexOf() {
        // given
        simpleArrayList.add("glen");
        simpleArrayList.add("doggy");

        // expect
        assertThat(simpleArrayList.indexOf("glen"))
                .isEqualTo(0);
        assertThat(simpleArrayList.indexOf("doggy"))
                .isEqualTo(1);
        assertThat(simpleArrayList.indexOf("pobi"))
                .isEqualTo(-1);
    }

    @Test
    void size() {
        // given
        simpleArrayList.add("glen");
        simpleArrayList.add("doggy");

        // expect
        assertThat(simpleArrayList.size())
                .isEqualTo(2);
    }

    @Test
    void isEmpty() {
        // expect
        assertThat(simpleArrayList.isEmpty())
                .isTrue();

        simpleArrayList.add("glen");

        assertThat(simpleArrayList.isEmpty())
                .isFalse();
    }

    @Test
    void remove() {
        // given
        simpleArrayList.add("glen");

        // when
        simpleArrayList.remove("glen");

        // then
        assertThat(simpleArrayList.size())
                .isEqualTo(0);
    }

    @Test
    void remove2() {
        // given
        simpleArrayList.add("glen");

        // when
        simpleArrayList.remove(0);

        // then
        assertThat(simpleArrayList.size())
                .isEqualTo(0);
    }

    @Test
    void clear() {
        // given
        simpleArrayList.add("glen");

        // when
        simpleArrayList.clear();

        // then
        assertThat(simpleArrayList.isEmpty())
                .isTrue();
    }
}
