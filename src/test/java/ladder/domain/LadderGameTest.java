package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 내 플레이어 이름들은 처음 전달했을 때와 같아야 한다.")

    void ladderGameTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;

        LadderGame ladderGame = new LadderGame(names, height);
        List<String> playerNames = ladderGame.getNames();

        Assertions.assertTrue(playerNames.containsAll(names));
    }
}
