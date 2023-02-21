package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 건널 때 ")
    class CrossingLadderCase {
        private Ladder ladder;
    }
}