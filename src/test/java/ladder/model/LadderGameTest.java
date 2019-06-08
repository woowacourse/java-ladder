package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Members members = new Members(Arrays.asList("pobi", "hunux", "jk", "crong"));
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
        ladderGame = new LadderGame(members, 5, results);
    }

    @Test
    void 사다리_높이에_따라_row_생성되는지_확인() {
        int rowCount = ladderGame.getLadder().ladderHeight();
        assertThat(rowCount).isEqualTo(5);
    }
}
