package ladderGame.model.input;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    @Test
    void 글자수를_초과하는_입력() {
        String[] playerInputs = StringUtils.deleteWhitespace("pobi,ko,ole").split(",");
        Players players = PlayersFactory.getPlayers(Arrays.asList(playerInputs));
        String[] results = "꽝,고고씽씽씽싱,고고싱".split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            ResultsFactory.getResults(Arrays.asList(results), players.size());
        });
    }


    @Test
    void 이름들_입력보다_많은_결과들_입력() {
        String[] playerInputs = StringUtils.deleteWhitespace("pobi,ko").split(",");
        Players players = PlayersFactory.getPlayers(Arrays.asList(playerInputs));
        String[] results = "꽝,고싱,고고싱".split(",");
        assertThrows(IllegalStateException.class, () -> {
            ResultsFactory.getResults(Arrays.asList(results), players.size());
        });
    }

    @Test
    void 정상_입력() {
        String[] playerInputs = StringUtils.deleteWhitespace("pobi,ko,ole").split(",");
        Players players = PlayersFactory.getPlayers(Arrays.asList(playerInputs));
        String[] results = "꽝,고싱,고고싱".split(",");
        assertDoesNotThrow(() -> {
            ResultsFactory.getResults(Arrays.asList(results), players.size());
        });
    }

}
