package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    Members members;
    List<String> results;
    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        members = new Members(Arrays.asList("a", "bb", "ccc", "dddd", "eeeee"));
        results = Arrays.asList("1", "2", "3", "4", "5");
        ladderGame = new LadderGame(members, 5, results);
    }

    @Test
    void row_생성() {
        int rowCount = ladderGame.getLadder().ladderHeight();
        assertThat(rowCount).isEqualTo(5);
    }
}
