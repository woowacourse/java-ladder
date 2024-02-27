package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.result.message.ResultExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TotalResultsTest {

    @Nested
    @DisplayName("총 실행 결과 생성 예외 테스트")
    class TotalResultsExceptionTest {

        @Test
        @DisplayName("참가자 수와 실행 결과 수가 동일하지 않으면 예외가 발생한다")
        void createTotalResultsFailBySize() {
            // given
            PlayerName player1 = new PlayerName("aa");
            PlayerName player2 = new PlayerName("bb");
            PlayerName player3 = new PlayerName("cc");
            PlayerNames playerNames = new PlayerNames(List.of(player1, player2, player3));

            LadderResult ladderResult1 = new LadderResult("꽝");
            LadderResult ladderResult2 = new LadderResult("당첨");
            List<LadderResult> ladderResults = List.of(ladderResult1, ladderResult2);

            // then
            assertThatThrownBy(() -> new TotalResults(ladderResults, playerNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }

    }
}
