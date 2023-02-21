package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "add 메소드에 index와 value를 전달하면, 해당 인덱스에 value를 추가한다.")
    @ValueSource(ints = {0, 1, 2})
    void indexAddTest(int index) {
        String expected = "inserted";
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        simpleArrayList.add(index, expected);

        String result = simpleArrayList.get(index);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("add 메소드에 전달된 index가 범위를 벗어나는 경우 예외를 던진다.")
    void addOutOfIndexTest() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThatThrownBy(() -> simpleArrayList.add(3, "asdf"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void set() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        String oldValue = simpleArrayList.set(1, "third");

        assertAll(() -> assertThat(oldValue).isEqualTo("second")
                , () -> assertThat(simpleArrayList.get(1)).isEqualTo("third")
        );
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
    @DisplayName("list가 비어있으면 true를 리턴한다.")
    void isEmptyTrueTest() {
        assertThat(simpleArrayList.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("list가 비어있지 않으면 false를 리턴한다.")
    void isEmptyFalseTest() {
        simpleArrayList.add("first");

        assertThat(simpleArrayList.isEmpty()).isFalse();
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
