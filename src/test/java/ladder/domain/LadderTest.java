package ladder.domain;

import static ladder.Util.createLines;
import static ladder.Util.createPlayers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // given
        int height = 3;

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(createLines(height,12), createPlayers(12));
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // given
        int height = 10;

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(createLines(height, 3), createPlayers(3));
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            new Ladder(createLines(3, 3), createPlayers(3));
        });
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
                .isEqualTo(0);
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
            new Ladder(createLines(4, 3), createPlayers(4));
        });
    }

    private Ladder createLadder() {
        return new Ladder(List.of(
                new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY))
        ), createPlayers(4));
    }
}
