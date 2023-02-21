package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 내 플레이어 이름들은 처음 전달했을 때와 같아야 한다.")
    void ladderGamePlayerNamesTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;

        LadderGame ladderGame = new LadderGame(names, height, Collections.emptyList());
        List<String> playerNames = ladderGame.getNames();

        Assertions.assertTrue(playerNames.containsAll(names));
    }

    @Test
    @DisplayName("사다리 게임 내 게임결과들은 처음 전달했을 때와 같아야 한다.")
    void ladderGameResultsTest() {
        List<String> names = List.of("pobi", "crong", "seong");
        int height = 5;
        List<String> inputResults = List.of("꽝", "4000", "당첨");

        LadderGame ladderGame = new LadderGame(names, height, inputResults);
        List<String> results = ladderGame.getResults();

        Assertions.assertTrue(results.containsAll(inputResults));

    }
}
