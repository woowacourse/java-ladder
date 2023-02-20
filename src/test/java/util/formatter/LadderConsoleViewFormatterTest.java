package util.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LadderGame;
import domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;

class LadderConsoleViewFormatterTest {

    @DisplayName("사다리 출력 형식 생성 테스트")
    @Test
    void ladderFormatterTest() {
        LadderGame ladderGame = TestDataManager.getLadderGame();
        Ladder ladder = ladderGame.getLadder();
        ladder.buildBridges();
        String expected =
                  "  |-----|     |" + System.lineSeparator()
                + "  |-----|     |" + System.lineSeparator()
                + "  |-----|     |";

        String formatContent = LadderConsoleViewFormatter.formatLadder(ladder);
        assertThat(formatContent).isEqualTo(expected);
    }


}
