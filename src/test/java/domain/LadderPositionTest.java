package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPositionTest {

    @Test
    @DisplayName("위치 값이 0 이상의 양수일 경우 예외가 발생하지 않음")
    void testCreateLadderPosition() {
        Assertions.assertThatCode(() -> new LadderPositions(List.of(1, 2)))
                .doesNotThrowAnyException();

    }

    @Test
    @DisplayName("위차 값이 부적절(0 미만 9 초과)할 경우 예외 발생")
    void validateLength() {
        Assertions.assertThatThrownBy(() -> new LadderPositions(List.of(1)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_POSITIONS_RANGE.getMessage());
        Assertions.assertThatThrownBy(() -> new LadderPositions(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_POSITIONS_RANGE.getMessage());
    }

    @Test
    @DisplayName("위치 값이 적절하면 위치 값을 반환할 수 있음")
    void testGetPosition() {
        LadderPositions ladderPositions = new LadderPositions(List.of(0, 1, 2, 3, 4));
        List<Integer> actual = ladderPositions.getPositions();
        List<Integer> expected = List.of(0, 1, 2, 3, 4);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 가로 값으로 위치를 반환할 수 있음")
    void testCalculatePosition() {
        LadderPositions ladderPositions = new LadderPositions(List.of(1, 2, 3));
        // row = |     |-----|
        Row row = new Row(List.of(Bridge.NONE, Bridge.EXIST));

        LadderPositions actual = ladderPositions.calculatePosition(row);
        LadderPositions expected = new LadderPositions(List.of(1, 3, 2));

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}