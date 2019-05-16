package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void 사다리_높이에_따라_row_생성되는지_확인() {
        String[] names = {"pobi", "crong"};
        LadderGame ladderGame = new LadderGame(names, 3);
        int rowCount = ladderGame.getLadderHeight();
        assertThat(rowCount).isEqualTo(3);
    }
}
