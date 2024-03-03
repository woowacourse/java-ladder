package model.gameresult;

import static model.bridge.Bridge.CONNECTED;
import static model.bridge.Bridge.UNCONNECTED;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.ladder.Ladder;
import model.ladder.LadderResult;
import model.line.Line;
import model.player.Players;
import model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    Players players = Players.of(List.of("jojo", "woo", "lee", "dora"));
    Prizes prizes = Prizes.of(List.of("꽝", "박수", "칭찬", "박장대소"), players);

    @DisplayName("참가자와 실행 결과를 연결해 게임 결과 생성한다")
    @Test
    void testGenerateGameResultFromPlayersAndPrizes() {
        LadderResult ladderResult = prepareLadderResult();
        GameResult gameResult = GameResult.of(ladderResult, players, prizes);

        assertAll(
            () -> assertEquals(gameResult.findPrizeByPlayerName("jojo").getName(), "꽝"),
            () -> assertEquals(gameResult.findPrizeByPlayerName("woo").getName(), "칭찬"),
            () -> assertEquals(gameResult.findPrizeByPlayerName("lee").getName(), "박장대소"),
            () -> assertEquals(gameResult.findPrizeByPlayerName("dora").getName(), "박수")
        );
    }

    private LadderResult prepareLadderResult() {
        Ladder ladder = new Ladder(List.of(
            new Line(List.of(CONNECTED, UNCONNECTED, UNCONNECTED)),
            new Line(List.of(CONNECTED, UNCONNECTED, CONNECTED)),
            new Line(List.of(UNCONNECTED, CONNECTED, UNCONNECTED))
        ));
        return LadderResult.from(ladder);
    }
}
