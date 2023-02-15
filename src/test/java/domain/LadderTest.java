package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    private List<Line> makeLines() {
        Line line1 = new Line(List.of(Step.EMPTY));
        Line line2 = new Line(List.of(Step.EMPTY));
        Line line3 = new Line(List.of(Step.EMPTY));
        Line line4 = new Line(List.of(Step.EMPTY));
        Line line5 = new Line(List.of(Step.EMPTY));
        return List.of(line1, line2, line3, line4, line5);
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(makeLines(), 12);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(makeLines(), 2);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            new Ladder(makeLines(), 3);
        });
    }
}
