package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @ValueSource(ints = {0, 1})
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
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
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
    @DisplayName("get 메소드로 size보다 큰 index를 전달하면 예외를 발생한다.")
    void getFailureTest() {
        String expected = "first";
        simpleArrayList.add(expected);

        assertThatThrownBy(() -> simpleArrayList.get(1))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("list에 포함된 value면 true를 리턴한다.")
    void contains() {
        simpleArrayList.add("first");

        assertThat(simpleArrayList.contains("first")).isTrue();
    }

    @Test
    @DisplayName("list에 포함되지 않은 value면 false 리턴한다.")
    void containsFalseTest() {
        assertThat(simpleArrayList.contains("first")).isFalse();
    }

    @Test
    @DisplayName("indexOf 메서드에 value를 전달하면, 해당 value의 인덱스를 반환한다.")
    void indexOf() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        int index = simpleArrayList.indexOf("second");

        assertThat(index).isEqualTo(1);
    }

    @Test
    @DisplayName("indexOf 메서드에 전달된 value가 존재하지 않으면 -1을 반환한다")
    void indexOfFailureTest() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        int index = simpleArrayList.indexOf("fourth");

        assertThat(index).isEqualTo(-1);
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
    @DisplayName("remove에 value를 전달하면, 해당 value가 지워진다.")
    void removeValueTest() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        simpleArrayList.remove("second");

        assertAll(() -> assertThat(simpleArrayList.size()).isEqualTo(2)
                , () -> assertThatThrownBy(() -> simpleArrayList.get(2))
                        .isInstanceOf(ArrayIndexOutOfBoundsException.class)
        );
    }

    @Test
    @DisplayName("remove에 index 전달하면, 해당 value가 지워지고 지워진 값을 반환한다.")
    void removeIndexTest() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        String removedValue = simpleArrayList.remove(1);

        assertAll(() -> assertThat(simpleArrayList.size()).isEqualTo(2)
                , () -> assertThat(removedValue).isEqualTo("second"));
    }

    @Test
    void clear() {
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        simpleArrayList.clear();

        assertThat(simpleArrayList.size()).isEqualTo(0);
    }
}
