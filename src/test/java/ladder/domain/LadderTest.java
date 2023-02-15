package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderTest {
    private final int heightOfLadder = 5;
    private final int playerCount = 5;

    @Test
    @DisplayName("사다리 생성을 테스트")
    void ladderInitiatorTest() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < heightOfLadder; i++) {
            List<Bar> bars = LineMaker.generate(playerCount, new MockRandomDataGenerator());
            lines.add(new Line(bars));
        }

        Assertions.assertDoesNotThrow(() -> new Ladder(lines));
    }
}
