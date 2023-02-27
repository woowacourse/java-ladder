package laddergame.domain.ladder.line;

import static laddergame.domain.ladder.line.Direction.DOWN;
import static laddergame.domain.ladder.line.Direction.LEFT;
import static laddergame.domain.ladder.line.Direction.RIGHT;
import static laddergame.domain.ladder.line.StepPoint.EXIST;
import static laddergame.domain.ladder.line.StepPoint.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DirectionTest {

    @Test
    @DisplayName("양쪽 디딤대 좌표값의 상태에 따라서 이동할 방향을 반환한다.")
    void should_ReturnDirection_When_GivenBothSideStepPoints() {
        assertThat(Direction.findDirection(NONE, NONE))
                .isEqualTo(DOWN);
        assertThat(Direction.findDirection(EXIST, NONE))
                .isEqualTo(LEFT);
        assertThat(Direction.findDirection(NONE, EXIST))
                .isEqualTo(RIGHT);
    }

    @Test
    @DisplayName("양쪽 디딤대가 연속될 경우 예외를 던진다.")
    void should_ThrowException_When_GivenContinuousStepPoints() {
        assertThatThrownBy(() -> Direction.findDirection(EXIST, EXIST))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연속된 디딤대 좌표값으로는 사다리 방향을 결정할 수 없습니다.");
    }

    @Test
    @DisplayName("각 방향은 현재 위치값을 이용해 다음 위치값을 반환한다.")
    void should_ReturnNextIndex_When_Given_Current_Index() {
        int currentIndex = 2;
        Assertions.assertThat(DOWN.computeNextIndex(currentIndex)).isEqualTo(currentIndex);
        Assertions.assertThat(LEFT.computeNextIndex(currentIndex)).isEqualTo(1);
        Assertions.assertThat(RIGHT.computeNextIndex(currentIndex)).isEqualTo(3);
    }
}
