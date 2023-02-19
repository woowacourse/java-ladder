package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("Step이 연속되면 예외가 발생한다.")
    void create_stepContinuous() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(List.of(Step.EMPTY, Step.EXIST, Step.EXIST));
        }).withMessage("[ERROR] 라인에 Step이 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("Step이 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        Line line = new Line(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));

        // expect
        assertThat(line.getSize())
                .isEqualTo(3);
    }
}
