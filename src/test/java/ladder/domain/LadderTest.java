package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    BooleanGenerator booleanGenerator;

    @BeforeEach
    void settings() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        booleanGenerator = new IntendedBooleanGenerator();
    }

    @Test
    @DisplayName("사다리가 라인 수에 맞게 생성된다.")
    void generateLadderTest() {
        LadderSize ladderSize = new LadderSize(5, 5);
        Ladder ladder = new Ladder(ladderSize, booleanGenerator);

        List<Line> copiedLines = ladder.getLines();
        assertEquals(5, copiedLines.size());
    }

    @Test
    @DisplayName("사다리 게임 실행 결과 후 비교")
    void ladderGameStartTest() {
        LadderSize ladderSize = new LadderSize(2, 3);

        /** 0     1     2
         *  |-----|     |
         *  |-----|     |
         *  |-----|     |
         *  0     1     2
         */

        Ladder ladder = new Ladder(ladderSize, booleanGenerator);
        int firstPlayerPrizeIndex = ladder.getEachPlayerPrize(0, 0);
        int secondPlayerPrizeIndex = ladder.getEachPlayerPrize(0, 1);
        int thirdPlayerPrizeIndex = ladder.getEachPlayerPrize(0, 2);

        assertThat(firstPlayerPrizeIndex).isEqualTo(1);
        assertThat(secondPlayerPrizeIndex).isEqualTo(0);
        assertThat(thirdPlayerPrizeIndex).isEqualTo(2);
    }
}
