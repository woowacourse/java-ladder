package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private int heightOfLadder;
    private int playerCount;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        heightOfLadder = 5;
        playerCount = 5;
        ladder = Ladder.of(playerCount, heightOfLadder, new MockRandomBarGenerator());
    }

    /**
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     */
    @Test
    @DisplayName("4*5 사이즈의 사다리가 생성되는지 확인한다")
    void ladderInitiatorTest() {
        List<Line> lines = ladder.getLinesOfLadder();

        int rowSize = lines.size();
        int columnSize = lines.get(0).getLine().size();

        assertThat(rowSize == heightOfLadder && columnSize == playerCount - 1).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    @DisplayName("사다리에 출발점을 넣으면 예상된 도착점을 반환한다")
    void traceThePathTest(int start, int end) {
        assertThat(ladder.findEndPositionFrom(start))
                .isEqualTo(end);
    }

}
