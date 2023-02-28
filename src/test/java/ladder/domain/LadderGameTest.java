package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

    BooleanGenerator booleanGenerator;
    LadderGame ladderGame;

    @BeforeEach
    void setting() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        /** pobi crong seong
         *     |-----|     |
         *     |-----|     |
         *     |-----|     |
         *     |-----|     |
         *     |-----|     |
         *     꽝 4000    당첨
         *
         *     결과 = pobi : 4000
         *           crong : 꽝
         *           seong : 당첨
         */

        booleanGenerator = new IntendedBooleanGenerator();

        List<String> names = List.of("pobi", "crong", "seong");
        int height = 5;
        List<String> prizes = List.of("꽝", "4000", "당첨");
        ladderGame = new LadderGame(names, height, prizes, booleanGenerator);
    }

    @Test
    @DisplayName("사다리 게임 내 플레이어 이름들은 처음 전달했을 때와 같아야 한다.")
    void ladderGamePlayerNamesTest() {
        List<String> playerNames = ladderGame.getNames();
        assertTrue(playerNames.containsAll(List.of("pobi", "crong", "seong")));
    }

    @Test
    @DisplayName("사다리 게임 내 당첨결과들은 처음 전달했을 때와 같아야 한다.")
    void ladderGamePrizesTest() {
        List<String> results = ladderGame.getPrizes();
        assertTrue(results.containsAll(List.of("꽝", "4000", "당첨")));
    }

    @Test
    @DisplayName("플레이어 이름이 all이면 사다리게임이 끝나야한다.")
    void gameContinueTest() {
        String playerName = "all";
        assertFalse(ladderGame.continueGame(playerName));
    }

    @Test
    @DisplayName("플레이어 한 명의 게임 결과의 반환 Map의 사이즈는 1이어야한다.")
    void getOnePlayerGameResultTest() {
        ladderGame.start();
        HashMap<String, String> gameResult = ladderGame.getGameResult("pobi");
        assertEquals(1, gameResult.size());
    }

    @Test
    @DisplayName("플레이어 전체의 게임 결과의 반환 Map의 사이즈는 플레이어의 수와 같아야한다.")
    void getGameAllPlayerResultTest() {
        ladderGame.start();
        HashMap<String, String> gameResult = ladderGame.getGameResult("all");
        assertEquals(3, gameResult.size());
    }

    @Test
    @DisplayName("플레이어 한 명의 게임 결과값 일치 테스트")
    void matchEachPlayerToPrizeTest() {
        ladderGame.start();
        HashMap<String, String> gameResult = ladderGame.getGameResult("all");
        assertEquals("4000", gameResult.get("pobi"));
        assertEquals("꽝", gameResult.get("crong"));
        assertEquals("당첨", gameResult.get("seong"));
    }
}
