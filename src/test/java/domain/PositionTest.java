package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @DisplayName("주어진 방향으로 위치를 이동한다.")
    @ParameterizedTest
    @ValueSource(strings = {"LEFT,0", "RIGHT,2", "NONE,1"})
    void move(String inputs) {
        //given
        Direction direction = Direction.valueOf(List.of(inputs.split(",")).get(0));
        Position position = new Position(1);
        int expectedPosition = Integer.parseInt(List.of(inputs.split(",")).get(1));

        //when
        position.move(direction);

        //then
        assertThat(position.getValue()).isEqualTo(expectedPosition);
    }
}
