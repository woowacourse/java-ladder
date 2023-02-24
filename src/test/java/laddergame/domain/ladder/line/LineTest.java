package laddergame.domain.ladder.line;

import static laddergame.domain.ladder.line.Direction.LEFT;
import static laddergame.domain.ladder.line.Direction.RIGHT;
import static laddergame.domain.ladder.line.StepPoint.EXIST;
import static laddergame.domain.ladder.line.StepPoint.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import laddergame.domain.generator.RandomStepPointGenerator;
import laddergame.domain.ladder.MockedPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    @DisplayName("라인은 주어진 폭 만큼의 방향을 가진다.")
    void should_HasDirections_Of_GivenWidth() {
        Line line = Line.of(new RandomStepPointGenerator(), new LineWidth(5));

        assertThat(line.toDirections())
                .hasSize(5);
    }

    @Test
    @DisplayName("주어진 개수 만큼의 방향을 주어진 생성방식에 따라 생성된다.")
    void should_GenerateDirections_By_GivenStepPointGenerator() {
        List<StepPoint> stepPoints = List.of(EXIST, NONE, EXIST, NONE, EXIST);
        Queue<StepPoint> generateValues = new LinkedList<>(stepPoints);

        Line line = Line.of(new MockedPointGenerator(generateValues), new LineWidth(stepPoints.size() + 1));

        List<Direction> expected = List.of(RIGHT, LEFT, RIGHT, LEFT, RIGHT, LEFT);
        assertThat(line.toDirections()).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인 생성 시 연속된 디딤대를 제공하면 예외를 던진다.")
    void should_ThrowException_When_GenerateContinuousStepPoints() {
        List<StepPoint> stepPoints = List.of(EXIST, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(stepPoints);

        assertThatThrownBy(
                () -> Line.of(new MockedPointGenerator(generateValues), new LineWidth(stepPoints.size() + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("디딤대는 연속적으로 존재할 수 없습니다.");
    }

    @Test
    @DisplayName("주어진 위치에서 이동할 방향을 반환한다.")
    void should_ReturnDirectionToMove_By_Index() {
        List<StepPoint> stepPoints = List.of(EXIST, NONE, EXIST, NONE, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(stepPoints);
        Line line = Line.of(new MockedPointGenerator(generateValues), new LineWidth(stepPoints.size() + 1));

        assertThat(line.findNextLineIndex(0)).isEqualTo(1);
    }
}
