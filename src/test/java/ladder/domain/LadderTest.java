package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.LadderDirection.RIGHT;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사람 수와 높이를 입력받아 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        Ladder ladder = Ladder.of(
                new Players(List.of("poby", "honux", "crong", "jk")),
                new Height(5),
                new DefaultLadderDirectionSelector());

        List<LadderLevel> ladderLevels = ladder.getLadderLevels();
        List<LadderDirection> ladderDirections = ladderLevels.get(0).getLadderDirections();

        assertAll(
                () -> assertThat(ladderLevels).hasSize(5),
                () -> assertThat(ladderDirections).hasSize(4)
        );
    }

    @DisplayName("사다리의 출발점을 입력하면 도착점을 반환한다.")
    @Test
    void climbFrom() {
        Ladder ladder = Ladder.of(
                new Players(List.of("poby", "honux", "crong", "jk")),
                new Height(5),
                () -> RIGHT);

        assertAll(
                () -> assertThat(ladder.climbFrom(new LadderPosition(0, 0)))
                        .isEqualTo(new LadderPosition(5, 1)),
                () -> assertThat(ladder.climbFrom(new LadderPosition(0, 1)))
                        .isEqualTo(new LadderPosition(5, 0)),
                () -> assertThat(ladder.climbFrom(new LadderPosition(0, 2)))
                        .isEqualTo(new LadderPosition(5, 3)),
                () -> assertThat(ladder.climbFrom(new LadderPosition(0, 3)))
                        .isEqualTo(new LadderPosition(5, 2))
        );
    }
}
