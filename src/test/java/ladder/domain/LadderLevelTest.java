package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

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

        List<Direction> directions = ladderLevel.toDirectionList();

        assertThat(directions.size()).isEqualTo(100);
        assertThat(directions).doesNotContain(RIGHT, LEFT);
    }

    @DisplayName("가로줄로 가득 찬 사다리 층이 생성된다.")
    @Test
    void ladderLevelIntegrityTest() {
        LadderLevel ladderLevel = LadderLevelBuilder.builder()
                .size(100)
                .directionSelector(() -> RIGHT)
                .build();

        List<Direction> directions = ladderLevel.toDirectionList();

        assertThat(directions).doesNotContain(NONE);
        assertThat(directions).contains(RIGHT, LEFT);
    }
}
