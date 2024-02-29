package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.ladder.Ladder;
import domain.ladder.LadderBridge;
import domain.ladder.LadderHeight;
import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @Test
    @DisplayName("참가자 수와 실행 결과 수가 동일하지 않으면 예외가 발생한다")
    void createTotalResultsFailBySize() {
        // given
        Player player1 = new Player(new PlayerName("aa"), 0);
        Player player2 = new Player(new PlayerName("bb"), 0);
        Player player3 = new Player(new PlayerName("cc"), 0);

        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        LadderHeight ladderHeight = new LadderHeight(2);

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");

        // when
        Players players = new Players(List.of(player1, player2, player3));
        bridgeGeneratorStub.setBridges(List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE));
        Ladder ladder = Ladder.of(ladderHeight, players, bridgeGeneratorStub);
        List<LadderResult> ladderResults = List.of(ladderResult1, ladderResult2);

        // then
        assertThatThrownBy(() -> new LadderResults(players, ladder, ladderResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
    }

    @Test
    @DisplayName("참가자 수와 실행 결과 수가 동일하면 정상적으로 생성된다")
    void createTotalResultsSuccessWithSize() {
        // given
        Player player1 = new Player(new PlayerName("aa"), 0);
        Player player2 = new Player(new PlayerName("bb"), 0);

        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        LadderHeight ladderHeight = new LadderHeight(2);

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");

        // when
        Players players = new Players(List.of(player1, player2));
        bridgeGeneratorStub.setBridges(List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE));
        Ladder ladder = Ladder.of(ladderHeight, players, bridgeGeneratorStub);
        List<LadderResult> ladderResults = List.of(ladderResult1, ladderResult2);

        // then
        assertThatCode(() -> new LadderResults(players, ladder, ladderResults))
                .doesNotThrowAnyException();
    }
}
