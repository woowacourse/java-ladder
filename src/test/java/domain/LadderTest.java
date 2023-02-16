package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.LadderRowGenerator;

public class LadderTest {

    @Test
    @DisplayName("parseLadderToString은 사다리의 정보를 문자열로 변환한다.")
    void parseLadderToStringTest() {
        LadderRowGenerator ladderRowGenerator = new TestLadderRowGenerator();
        Ladder ladder = new Ladder(ladderRowGenerator);

        ladder.create(5, 4);
        String ladderRow1 = "    |-----|     |-----|";
        String ladderRow2 = "    |     |-----|     |";
        String ladderRow3 = "    |-----|     |     |";
        String ladderRow4 = "    |     |-----|     |";
        String ladderRow5 = "    |-----|     |-----|";

        assertThat(ladder.parseLadderToString())
                .containsExactly(ladderRow1, ladderRow2, ladderRow3, ladderRow4, ladderRow5);
    }

    static class TestLadderRowGenerator implements LadderRowGenerator {

        private final List<List<Boolean>> ladder = List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(false, true, false),
                List.of(true, false, true)
        );

        private int index = 0;

        @Override
        public LadderRow generate(int userCount) {
            return new LadderRow(ladder.get(index++));
        }
    }
}
