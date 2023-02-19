package ladder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.Line;
import ladder.domain.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineStrategyTest {

    @Test
    @DisplayName("랜덤하게 Line의 생성이 정상적으로 되어야 한다.")
    void create_randomSuccess() {
        // given
        LineStrategy lineStrategy = new RandomLineStrategy();

        // when
        Line line = lineStrategy.generate(5);

        // then
        assertThat(line.getSize())
                .isEqualTo(4);
    }

    @Test
    @DisplayName("사용자 정의 Line의 생성이 정상적으로 되어야 한다.")
    void create_customSuccess() {
        // given
        LineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));

        // when
        Line line = lineStrategy.generate(4);
        List<Step> steps = line.getSteps();

        // then
        assertThat(line.getSize())
                .isEqualTo(3);
        assertThat(steps)
                .isEqualTo(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));
    }
}
