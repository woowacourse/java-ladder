package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.player.PlayerName;
import domain.player.PlayerNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @Test
    @DisplayName("참가자 수와 실행 결과 수가 동일하지 않으면 예외가 발생한다")
    void createTotalResultsFailBySize() {
        // given
        PlayerName playerName1 = new PlayerName("aa");
        PlayerName playerName2 = new PlayerName("bb");
        PlayerName playerName3 = new PlayerName("cc");

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");

        // when
        PlayerNames playerNames = new PlayerNames(List.of(playerName1, playerName2, playerName3));
        List<LadderResult> ladderResults = List.of(ladderResult1, ladderResult2);

        // then
        assertThatThrownBy(() -> LadderResults.createMatchesCountOf(playerNames.getPlayerCount(), ladderResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LadderResults.TOTAL_RESULTS_SIZE);
    }

    @Test
    @DisplayName("참가자 수와 실행 결과 수가 동일하면 정상적으로 생성된다")
    void createTotalResultsSuccessWithSize() {
        // given
        PlayerName playerName1 = new PlayerName("aa");
        PlayerName playerName2 = new PlayerName("bb");

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");

        // when
        PlayerNames playerNames = new PlayerNames(List.of(playerName1, playerName2));
        List<LadderResult> ladderResults = List.of(ladderResult1, ladderResult2);

        // then
        assertThatCode(() -> LadderResults.createMatchesCountOf(playerNames.getPlayerCount(), ladderResults))
                .doesNotThrowAnyException();
    }
}
