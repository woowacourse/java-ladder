package model.gameresult;

import static model.bridge.Bridge.CONNECTED;
import static model.bridge.Bridge.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.ladder.Ladder;
import model.ladder.LadderResult;
import model.line.Line;
import model.player.Players;
import model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

    @DisplayName("존재하는 참가자의 실행 결과 조회 성공")
    @ParameterizedTest
    @CsvSource({"jojo,꽝", "woo,칭찬", "lee,박장대소", "dora,박수"})
    void testValidPlayerNameSearching(String playerName, String prizeName) {
        GameResult gameResult = prepareGameResult();

        assertThat(gameResult.findPrizeByPlayerName(playerName).getName())
            .isEqualTo(prizeName);
    }

    private GameResult prepareGameResult() {
        Players players = Players.of(List.of("jojo", "woo", "lee", "dora"));
        Prizes prizes = Prizes.of(List.of("꽝", "박수", "칭찬", "박장대소"), players);
        Ladder ladder = new Ladder(List.of(
            Line.of(List.of(CONNECTED, UNCONNECTED, UNCONNECTED)),
            Line.of(List.of(CONNECTED, UNCONNECTED, CONNECTED)),
            Line.of(List.of(UNCONNECTED, CONNECTED, UNCONNECTED))
        ));
        LadderResult ladderResult = LadderResult.from(ladder);
        return GameResult.of(ladderResult, players, prizes);
    }

    @DisplayName("존재하지 않는 참가자를 조회하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"조조", "우", "리", ""})
    void testInvalidPlayerNameSearching(String playerName) {
        GameResult gameResult = prepareGameResult();

        assertThatThrownBy(() -> gameResult.findPrizeByPlayerName(playerName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
