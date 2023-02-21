package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;
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
        assertThat(simpleArrayList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add 메소드를 통해 value를 추가하면 size가 증가한다.")
    void add() {
        simpleArrayList.add("first");
        assertThat(simpleArrayList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("add 메소드 실행시 배열이 가득차면, 배열을 확장한다.")
    void addTestWhenIsFull() {
        simpleArrayList.add("first");
        assertThatCode(() -> simpleArrayList.add("second"))
                .doesNotThrowAnyException();
    }

    @Test
    void set() {
    }

    @Test
    @DisplayName("get 메소드로 index를 전달하면, 해당인덱스에 할당된 value를 리턴한다.")
    void get() {
        String expected = "first";
        simpleArrayList.add(expected);

        String result = simpleArrayList.get(0);

        assertThat(result).isEqualTo(expected);
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
