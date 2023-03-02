package ladder.domain;

import static ladder.Util.createLines;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        Ladder ladder = new Ladder(createLines(3, 3), 3);

        // expect
        assertThat(ladder.getLines())
                .hasSize(3);
    }

    @Test
    @DisplayName("사다리의 결과가 정확히 나와야 한다.")
    void getLadderIndexResult_success() {
        // given
        Ladder ladder = createLadder();

        // expect
        assertThat(ladder.getLadderIndexResult(0))
                .isEqualTo(2);
        assertThat(ladder.getLadderIndexResult(1))
                .isZero();
        assertThat(ladder.getLadderIndexResult(2))
                .isEqualTo(3);
        assertThat(ladder.getLadderIndexResult(3))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("사다리를 생성할 때 Line의 길이가 참여자와 맞지 않으면 예외가 발생한다.")
    void create_lineWidthNotMatchPlayerCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(createLines(4, 3), 4);
        }).withMessage("[ERROR] 사다리의 너비는 사람의 수와 같아야 합니다.");
    }

    private Ladder createLadder() {
        return new Ladder(List.of(
                new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY))
        ), 4);
    }
}
