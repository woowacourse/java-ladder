package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("최대 사다리 높이와 인원 수를 인자로 받아서 사다리를 생성한다.")
    void createLadder() {
        assertThatCode(() -> new Ladder(5, 3));
    }
}