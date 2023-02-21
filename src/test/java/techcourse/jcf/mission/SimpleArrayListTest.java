package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    private SimpleArrayList simpleArrayList;

    @BeforeEach
    void setUp() {
        this.simpleArrayList = new SimpleArrayList();
    }

    @Test
    @DisplayName("새로 생성된 SimpleArrayList의 size는 0 이다.")
    void constructedSimpleArrayListSizeTest() {
        Assertions.assertThat(simpleArrayList.size()).isEqualTo(0);
    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }


    @Test
    void isEmpty() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }
}
