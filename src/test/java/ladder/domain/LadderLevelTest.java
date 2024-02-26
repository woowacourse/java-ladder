package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("사다리의 한 층은 입력받은 크기로 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = new LadderLevel(2);

        int actualSize = (int) ladderLevel.stream().count();

        assertThat(actualSize).isEqualTo(2);
    }

    @DisplayName("Direction.RIGHT과 Direction.LEFT는 한 쌍으로만 생성된다.")
    @Test
    void ladderLevelIntegrityTest() {
        LadderLevel ladderLevel = new LadderLevel(2);
        List<LadderDirection> ladderDirections = ladderLevel.stream().toList();

        boolean isValid = ladderDirections.get(0) == RIGHT && ladderDirections.get(1) == LEFT;
        boolean isValidAlso = ladderDirections.get(0) == NONE && ladderDirections.get(1) == NONE;

        assertAll(
                () -> assertThat(isValid).isTrue(),
                () -> assertThat(isValidAlso).isTrue()
        );
    }
}
