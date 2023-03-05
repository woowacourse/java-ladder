package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.laddergame.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LadderTest {
    private final int heightOfLadder = 5;
    private final int playerCount = 5;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        ladder = Ladder.from(heightOfLadder, playerCount, new MockRandomBooleanGenerator());
    }

    /**
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     * true,false,true,false,
     */
    @Test
    @DisplayName("5*5 사이즈의 사다리가 생성되는지 확인한다")
    void ladderInitiatorTest() {
        final List<List<Boolean>> lines = ladder.getLadder();

        final int rowSize = lines.size();
        final int columnSize = lines.get(0)
                .size();

        assertThat(rowSize == heightOfLadder && columnSize == playerCount).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    @DisplayName("사다리에 출발점을 넣으면 예상된 도착점을 반환한다")
    void findEndPositionOf_Test(final int start, final int end) {
        final Position startPosition = new Position(start);
        final Position endPosition = new Position(end);

        assertThat(ladder.findEndPositionOf(startPosition))
                .isEqualTo(endPosition);
    }

}
