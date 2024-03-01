package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {
    @DisplayName("사다리의 한 층은 입력받은 크기로 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = new LadderLevel(new Width(2), () -> RIGHT);

        int actualSize = ladderLevel.getDirections().size();

        assertThat(actualSize).isEqualTo(2);
    }

    @DisplayName("RIGHT 이후엔 무조건 LEFT가 삽입되며, RIGHT은 마지막에 올 수 없다.")
    @Test
    void ladderLevelConstructTest2() {
        LadderLevel ladderLevel = new LadderLevel(new Width(3), () -> RIGHT);

        assertThat(ladderLevel.getDirections()).isEqualTo(List.of(RIGHT, LEFT, NONE));
    }

    @DisplayName("Direction에 따라 location을 바뀐다")
    @Test
    void ladderLevelMoveTest() {
        LadderLevel ladderLevel = new LadderLevel(new Width(2), () -> RIGHT);

        Location actual = ladderLevel.move(new Location(0));

        assertThat(actual).isEqualTo(new Location(1));
    }
}
