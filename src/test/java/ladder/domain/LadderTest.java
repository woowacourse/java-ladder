package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private int heightOfLadder;
    private int playerCount;

    @BeforeEach
    void setup() {
        heightOfLadder = 5;
        playerCount = 5;
    }

    @Test
    @DisplayName("4*5 사이즈의 사다리가 생성되는지 확인한다")
    void ladderInitiatorTest() {
        Ladder ladder = new Ladder(playerCount, heightOfLadder, new MockRandomDataGenerator());
        List<Line> lines = ladder.getLinesOfLadder();

        int rowSize = lines.size();
        int columnSize = lines.get(0).getLine().size();
        assertThat(rowSize == heightOfLadder && columnSize == playerCount - 1).isTrue();

    }
}
