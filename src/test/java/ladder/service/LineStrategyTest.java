package ladder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import ladder.domain.Line;
import ladder.domain.Step;
import java.util.List;
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
    @DisplayName("Line의 Step이 연속되면 안된다.")
    void create_continuousStep() {
        // given
        LineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EMPTY, Step.EXIST, Step.EXIST));

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lineStrategy.generate(4);
        }).withMessage("[ERROR] 라인에 Step이 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("Line이 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        CustomLineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));

        // expect
        assertThatNoException().isThrownBy(() -> {
            lineStrategy.generate(4);
        });
    }
}
