package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("사다리의 한 층은 입력받은 크기로 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = new LadderLevel(2, () -> RIGHT);

        int actualSize = (int) ladderLevel.stream().count();

        assertThat(actualSize).isEqualTo(2);
    }

    @DisplayName("Direction.RIGHT과 Direction.LEFT는 한 쌍으로만 생성된다.")
    @Test
    void ladderLevelIntegrityTest() {
        LadderLevel ladderLevel = new LadderLevel(2, () -> RIGHT);
        List<Direction> directions = ladderLevel.stream().toList();

        assertAll(
                () -> assertThat(directions.get(0)).isEqualTo(RIGHT),
                () -> assertThat(directions.get(1)).isEqualTo(LEFT)
        );
    }

    @DisplayName("Direction에 따라 location을 바뀐다")
    @Test
    void ladderLevelMoveTest() {
        LadderLevel ladderLevel = new LadderLevel(2, () -> RIGHT);

        int actual = ladderLevel.move(0);
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }
}
