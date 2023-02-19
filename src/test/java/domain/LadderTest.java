package domain;

import static domain.Line.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.LadderRowGenerator;

public class LadderTest {

    @Test
    @DisplayName("사다리의 가로 길이는 (사람 수 - 1)과 같다.")
    void should_ladderWidthIsSameToUserCount_when_ladderCreated() {
        LadderRowGenerator ladderRowGenerator = new TestLadderRowGenerator();
        int userCount = 4;

        Ladder ladder = new Ladder(userCount, 5, ladderRowGenerator);
        LadderRow ladderRow = ladder.getLadderRows().get(0);
        int ladderWidth = ladderRow.getLines().size();

        assertThat(ladderWidth).isEqualTo(userCount - 1);
    }

    @Test
    @DisplayName("사다리의 세로 길이는 사다리의 높이와 같다.")
    void should_ladderHeightIsSameToHeight_when_ladderCreated() {
        LadderRowGenerator ladderRowGenerator = new TestLadderRowGenerator();
        int height = 5;

        Ladder ladder = new Ladder(4, height, ladderRowGenerator);
        int ladderHeight = ladder.getLadderRows().size();

        assertThat(ladderHeight).isEqualTo(height);
    }

    static class TestLadderRowGenerator implements LadderRowGenerator {

        private final List<List<Line>> ladderRows = List.of(
                List.of(EXIST, NOT_EXIST, EXIST),
                List.of(NOT_EXIST, EXIST, NOT_EXIST),
                List.of(EXIST, NOT_EXIST, NOT_EXIST),
                List.of(NOT_EXIST, EXIST, NOT_EXIST),
                List.of(EXIST, NOT_EXIST, EXIST)
        );

        private int index = 0;

        @Override
        public LadderRow generate(int userCount) {
            return new LadderRow(ladderRows.get(index++));
        }
    }
}
