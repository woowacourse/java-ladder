package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositionTest {

    @DisplayName("해당 위치에서 오른쪽으로 이동할 수 있다.")
    @Test
    void canMoveRight(){
        //given
        Position position = new Position(0);
        Line line = Line.createByStrategy(new PickedBridgeGenerator(List.of(true,false)),3);

        //when
        boolean result = position.canMoveRight(line);

        //then
        assertThat(result).isTrue();
    }

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
}
