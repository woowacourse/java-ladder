package domain.ladder;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPositionsTest {

    @Test
    @DisplayName("위치 값 길이가 2 이상의 양수일 경우 예외가 발생하지 않음")
    void testCreateLadderPosition() {
        Assertions.assertThatCode(() -> new LadderPositions(2))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("위차 값이 부적절(0 미만 9 초과)할 경우 예외 발생")
    void validateLength(int invalidLength) {
        Assertions.assertThatThrownBy(() -> new LadderPositions(invalidLength))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_POSITIONS_RANGE.getMessage());
    }

    @Test
    @DisplayName("위치 값이 적절하면 위치 값을 반환")
    void testGetPositions() {
        LadderPositions ladderPositions = new LadderPositions(5);
        List<Integer> actual = ladderPositions.getPositions();
        List<Integer> expected = List.of(0, 1, 2, 3, 4);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("index 값을 전달하면 해당 index의 위치 값을 반환")
    void testGetPosition() {
        LadderPositions ladderPositions = new LadderPositions(3);
        Integer actual = ladderPositions.getPosition(2);
        Integer expected = 2;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치 값이 적절하면 위치 값 개수 반환")
    void testCount() {
        LadderPositions ladderPositions = new LadderPositions(5);
        int actual = ladderPositions.count();
        int expected = 5;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 가로 값으로 위치를 반환")
    void testCalculatePosition() {
        LadderPositions ladderPositions = new LadderPositions(3);
        // row = |     |-----|
        Row row = new Row(List.of(Bridge.NONE, Bridge.EXIST));

        LadderPositions calculatedPosition = ladderPositions.calculatePosition(row);
        List<Integer> actual = calculatedPosition.getPositions();
        List<Integer> expected = List.of(0, 2, 1);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}