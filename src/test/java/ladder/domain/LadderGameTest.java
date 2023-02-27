package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    BooleanGenerator booleanGenerator;

    @BeforeEach
    void setting() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        booleanGenerator = new IntendedBooleanGenerator();
    }

    @Test
    @DisplayName("사다리 게임 내 플레이어 이름들은 처음 전달했을 때와 같아야 한다.")
    void ladderGamePlayerNamesTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;
        List<String> prizes = List.of("꽝", "4000", "당첨", "3000");

        LadderGame ladderGame = new LadderGame(names, height, prizes, booleanGenerator);
        List<String> playerNames = ladderGame.getNames();

        Assertions.assertTrue(playerNames.containsAll(names));
    }

    @Test
    @DisplayName("사다리 게임 내 게임결과들은 처음 전달했을 때와 같아야 한다.")
    void ladderGamePrizesTest() {
        List<String> names = List.of("pobi", "crong", "seong");
        int height = 5;
        List<String> prizes = List.of("꽝", "4000", "당첨");

        LadderGame ladderGame = new LadderGame(names, height, prizes, booleanGenerator);
        List<String> results = ladderGame.getPrizes();

        Assertions.assertTrue(results.containsAll(prizes));
    }

    @Test
    @DisplayName("사다리 게임 실행 결과 후 비교")
    void ladderGameStartTest() {
        List<String> names = List.of("pobi", "crong", "seong");
        int height = 3;
        List<String> prizes = List.of("꽝", "4000", "당첨");

        /**pobi crong seong
         *  |-----|     |
         *  |-----|     |
         *  |-----|     |
         *  꽝   4000   당첨
         */

        LadderGame ladderGame = new LadderGame(names, height, prizes, booleanGenerator);
        ladderGame.start();
        assertThat(ladderGame.getGameResult("pobi").getGameResult().get(0)).isEqualTo("4000");
        assertThat(ladderGame.getGameResult("crong").getGameResult().get(0)).isEqualTo("꽝");
        assertThat(ladderGame.getGameResult("seong").getGameResult().get(0)).isEqualTo("당첨");
    }
}
