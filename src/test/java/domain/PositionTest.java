package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositionTest {

    @DisplayName("해당 위치는 첫번째 위치이다.")
    @Test
    void isFirstPositionTest() {
        //given
        Position position = new Position(0);

        //when
        boolean result = position.isFirst();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("해당 위치는 마지막 위치이다.")
    @Test
    void isLastPositionTest() {
        //given
        Position position = new Position(4);
        int lineSize = 4;

        //when
        boolean result = position.isLast(lineSize);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("주어진 위치는 첫번째 위치도, 마지막 위치도 아니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void isNotFirstOrLastPositionTest(int rawPosition) {
        //given
        Position position = new Position(rawPosition);
        int lineSize = 4;

        //when & then
        assertAll(
                () -> assertThat(position.isFirst()).isFalse(),
                () -> assertThat(position.isLast(lineSize)).isFalse()
        );
    }

    @DisplayName("주어진 위치의 왼쪽 위치 값을 반환한다.")
    @Test
    void findLeft() {
        //given
        Position position = new Position(2);
        int expectedPosition = 1;

        //when
        int result = position.findLeft();

        //then
        assertThat(result).isEqualTo(expectedPosition);
    }

    @DisplayName("주어진 위치의 오른쪽 위치 값을 반환한다.")
    @Test
    void findRight() {
        //given
        Position position = new Position(2);
        int expectedPosition = 3;

        //when
        int result = position.findRight();

        //then
        assertThat(result).isEqualTo(expectedPosition);
    }
}
