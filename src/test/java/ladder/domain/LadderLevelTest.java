package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("가로줄이 없는 사다리 층이 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = LadderLevelBuilder.builder()
                .size(100)
                .directionSelector(() -> NONE)
                .build();

        List<LadderDirection> ladderDirections = ladderLevel.toLadderDirectionList();

        assertThat(ladderDirections.size()).isEqualTo(100);
        assertThat(ladderDirections).doesNotContain(RIGHT, LEFT);
    }

    @DisplayName("가로줄로 가득 찬 사다리 층이 생성된다.")
    @Test
    void ladderLevelIntegrityTest() {
        LadderLevel ladderLevel = LadderLevelBuilder.builder()
                .size(100)
                .directionSelector(() -> RIGHT)
                .build();

        List<LadderDirection> ladderDirections = ladderLevel.toLadderDirectionList();

        assertThat(ladderDirections).doesNotContain(NONE);
        assertThat(ladderDirections).contains(RIGHT, LEFT);
    }
}
