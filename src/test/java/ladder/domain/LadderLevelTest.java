package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {
    @DisplayName("사다리의 한 층은 입력받은 크기로 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = new LadderLevel(new Width(2), () -> RIGHT);

        int actualSize = ladderLevel.getSortedDirections().size();

        assertThat(actualSize).isEqualTo(2);
    }

    @DisplayName("Direction에 따라 location을 바뀐다")
    @Test
    void ladderLevelMoveTest() {
        LadderLevel ladderLevel = new LadderLevel(new Width(2), () -> RIGHT);

        Location actual = ladderLevel.move(new Location(0));
        Location expected = new Location(1);

        assertThat(actual).isEqualTo(expected);
    }
}
