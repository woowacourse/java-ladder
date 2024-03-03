package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.ladder.direction.LadderDirection.NONE;
import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.ladder.direction.LadderDirection;

class LadderTest {

    @DisplayName("사람 수와 높이를 입력받아 사다리를 생성한다.")
    @Test
    void ladderConstructTest() {
        Ladder ladder = LadderBuilder.builder()
                .width(new Width(5))
                .height(new Height(4))
                .ladderDirectionSelector(() -> NONE)
                .build();

        List<LadderRow> ladderRows = ladder.getLadderRows();
        List<LadderDirection> ladderDirections = ladderRows.get(0).ladderRow();

        assertAll(
                () -> assertThat(ladderRows).hasSize(4),
                () -> assertThat(ladderDirections).hasSize(5)
        );
    }

    @DisplayName("사다리의 출발점을 입력하면 도착점을 반환한다.")
    @Test
    void climbDownFromTest() {
        Ladder ladder = LadderBuilder.builder()
                .width(new Width(4))
                .height(new Height(5))
                .ladderDirectionSelector(() -> RIGHT)
                .build();

        assertAll(
                () -> assertThat(ladder.climbDownFrom(new LadderPosition(0, 0)))
                        .isEqualTo(new LadderPosition(5, 1)),
                () -> assertThat(ladder.climbDownFrom(new LadderPosition(0, 1)))
                        .isEqualTo(new LadderPosition(5, 0)),
                () -> assertThat(ladder.climbDownFrom(new LadderPosition(0, 2)))
                        .isEqualTo(new LadderPosition(5, 3)),
                () -> assertThat(ladder.climbDownFrom(new LadderPosition(0, 3)))
                        .isEqualTo(new LadderPosition(5, 2))
        );
    }
}
