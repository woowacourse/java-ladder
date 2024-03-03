package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
import domain.result.ClimbingResults;
import domain.result.LadderResult;
import domain.result.LadderResults;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderClimbingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"'a','당첨'", "'b','꽝'", "'c','꽝'"})
    @DisplayName("사다리타기 결과를 생성한다.")
    void createClimbingResults(String playerName, String expected) {
        // given
        Player player1 = new Player(new PlayerName("a"), 0);
        Player player2 = new Player(new PlayerName("b"), 1);
        Player player3 = new Player(new PlayerName("c"), 2);

        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        LadderHeight ladderHeight = new LadderHeight(3);

        LadderResult ladderResult1 = new LadderResult("꽝");
        LadderResult ladderResult2 = new LadderResult("당첨");
        LadderResult ladderResult3 = new LadderResult("꽝");


        // when
        Players players = new Players(List.of(player1, player2, player3));
        bridgeGeneratorStub.setBridges(List.of(LadderBridge.BRIDGE, LadderBridge.NONE));
        LadderGenerator ladderGenerator = new LadderGenerator(ladderHeight, players, bridgeGeneratorStub);
        List<LadderResult> results = List.of(ladderResult1, ladderResult2, ladderResult3);
        LadderResults ladderResults = LadderResults.createMatchesCountOf(players.getPlayerCount(), results);
        LadderClimbingGame ladderClimbingGame = new LadderClimbingGame(players, ladderGenerator, ladderResults);
        ClimbingResults climbingResults = ladderClimbingGame.createClimbingResults();

         /* 사다리 형태
            aa    bb    cc
             |-----|     |
             |-----|     |
             |-----|     |
            꽝    당첨    꽝
         */

        // then
        assertThat(climbingResults.findResultByPlayerName(playerName).getValue()).isEqualTo(expected);
    }
}
