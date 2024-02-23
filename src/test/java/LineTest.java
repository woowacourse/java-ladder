import domain.*;
import mock.ExistStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    public static final Step EXIST_POINT = Step.EXIST;
    public static final Step EMPTY_POINT = Step.EMPTY;

    @DisplayName("기둥에 발판이 있으면 연결된 다음 기둥에는 발판이 없어야하고, 마지막 다리는 발판이 없다.")
    @Test
    void makeLineExist() {
        // given
        final Line line = Line.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new ExistStepGenerator());

        // when & then
        assertThat(line).isEqualTo(new Line(List.of(EXIST_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    @DisplayName("모든 기둥에 발판이 없는 경우를 확인한다.")
    @Test
    void makeLineEmpty() {
        // given
        final Line line = Line.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new EmptyStepGenerator());

        // when & then
        assertThat(line).isEqualTo(new Line(List.of(EMPTY_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    private static class EmptyStepGenerator implements StepGenerator {
        @Override
        public Step generate() {
            return Step.EMPTY;
        }
    }
}
