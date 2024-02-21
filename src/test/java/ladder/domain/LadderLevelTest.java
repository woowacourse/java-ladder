package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("라인에서 움직일 방향을 표현한다.")
    @Test
    void lineTest() {
        LadderLevel ladderLevel1 = new LadderLevel(4, () -> RIGHT);
        LadderLevel ladderLevel2 = new LadderLevel(4, () -> NONE);

        assertAll(
                () -> assertThat(ladderLevel1.getDirectionAt(0)).isEqualTo(RIGHT),
                () -> assertThat(ladderLevel1.getDirectionAt(1)).isEqualTo(LEFT),
                () -> assertThat(ladderLevel1.getDirectionAt(2)).isEqualTo(RIGHT),
                () -> assertThat(ladderLevel1.getDirectionAt(3)).isEqualTo(LEFT),

                () -> assertThat(ladderLevel2.getDirectionAt(0)).isEqualTo(NONE),
                () -> assertThat(ladderLevel2.getDirectionAt(1)).isEqualTo(NONE),
                () -> assertThat(ladderLevel2.getDirectionAt(2)).isEqualTo(NONE),
                () -> assertThat(ladderLevel2.getDirectionAt(3)).isEqualTo(NONE)
        );
    }
}
