import domain.Line;
import domain.PlayerCount;
import domain.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @DisplayName("직전 인덱스 값의 상태가 RIGHT이면 LEFT를 반환한다.")
    @Test
    void makeStepLeft() {
        Line line = new Line(PlayerCount.from(5));
        Step step = line.makeStep(List.of(Step.RIGHT), PlayerCount.from(5));

        Assertions.assertThat(step).isEqualTo(Step.LEFT);
    }

    @DisplayName("직전 인덱스 값의 상태가 RIGHT가 아닌 마지막 인덱스 값으로는 EMPTY를 반환한다.")
    @Test
    void makeStepEmpty() {
        Line line = new Line(PlayerCount.from(5));
        Step step = line.makeStep(List.of(Step.RIGHT, Step.LEFT, Step.RIGHT, Step.LEFT), PlayerCount.from(5));

        Assertions.assertThat(step).isEqualTo(Step.EMPTY);
    }
}
