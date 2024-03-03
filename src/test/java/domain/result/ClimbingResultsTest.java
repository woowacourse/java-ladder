package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.PlayerName;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClimbingResultsTest {
    static ClimbingResults climbingResults;

    @BeforeAll
    static void initClimbingResults() {
        PlayerName playerName1 = new PlayerName("a");
        PlayerName playerName2 = new PlayerName("b");
        PlayerName playerName3 = new PlayerName("c");

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");
        LadderResult ladderResult3 = new LadderResult("꽝");

        Map<PlayerName, LadderResult> results = new HashMap<>();
        results.put(playerName1, ladderResult1);
        results.put(playerName2, ladderResult2);
        results.put(playerName3, ladderResult3);

        climbingResults = new ClimbingResults(results);
    }

    @Test
    @DisplayName("사다리 게임에 참여한 사람이 아닌 경우 예외가 발생한다")
    void createClimbingResultsFailNotPlayer() {
        assertThatThrownBy(() -> climbingResults.findResultByPlayerName("kaki"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ClimbingResults.NOT_PARTICIPATION_PLAYER);
    }

    @ParameterizedTest
    @CsvSource(value = {"'a','꽝'", "'b','당첨'", "'c','꽝'"})
    @DisplayName("입력한 참가자의 사다리 타기 실행 결과를 보여준다.")
    void findResultByPlayerNameTest(String playerName, String expected) {
        assertThat(climbingResults.findResultByPlayerName(playerName).getValue()).isEqualTo(expected);
    }
}
