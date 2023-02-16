package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @Test
    void ladderGameTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;

        LadderGame ladderGame = new LadderGame(names, height);
        List<String> playerNames = ladderGame.getNames();

        Assertions.assertTrue(playerNames.containsAll(names));
    }
}
