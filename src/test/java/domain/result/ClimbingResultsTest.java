package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.Ladder;
import domain.ladder.LadderBridge;
import domain.ladder.LadderHeight;
import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClimbingResultsTest {
    static ClimbingResults climbingResults;

    @BeforeAll
    static void initClimbingResults() {
        Player player1 = new Player(new PlayerName("a"), 0);
        Player player2 = new Player(new PlayerName("b"), 1);
        Player player3 = new Player(new PlayerName("c"), 2);

        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        LadderHeight ladderHeight = new LadderHeight(2);

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");
        LadderResult ladderResult3 = new LadderResult("꽝");

        Players players = new Players(List.of(player1, player2, player3));
        bridgeGeneratorStub.setBridges(List.of(LadderBridge.BRIDGE, LadderBridge.NONE));
        Ladder ladder = Ladder.of(ladderHeight, players, bridgeGeneratorStub);
        List<LadderResult> results = List.of(ladderResult1, ladderResult2, ladderResult3);
        LadderResults ladderResults = new LadderResults(players, ladder, results);
        climbingResults = ClimbingResults.of(ladderResults);
    }

    @Test
    @DisplayName("사다리 게임에 참여한 사람이 아닌 경우 예외가 발생한다")
    void createClimbingResultsFailNotPlayer() {
        assertThatThrownBy(() -> climbingResults.findResultByPlayerName("kaki"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ResultExceptionMessage.NOT_PARTICIPATION_PLAYER);
    }

    @Test
    @DisplayName("입력한 참가자의 사다리 타기 실행 결과를 보여준다.")
    void findResultByPlayerNameTest() {
        assertAll(
                () -> assertThat(climbingResults.findResultByPlayerName("a")).isEqualTo("꽝"),
                () -> assertThat(climbingResults.findResultByPlayerName("b")).isEqualTo("당첨"),
                () -> assertThat(climbingResults.findResultByPlayerName("c")).isEqualTo("꽝")
        );
    }
}
