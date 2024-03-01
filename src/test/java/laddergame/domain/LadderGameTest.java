package laddergame.domain;

import laddergame.util.LinesGenerator;
import laddergame.util.RandomLinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 게임")
public class LadderGameTest {

    @Test
    @DisplayName("실행 결과 개수가 플레이어 수와 같지 않으면 오류가 발생한다.")
    void findExecutionResultCountIsPlayersCount() {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(
                        new Players(List.of("name1"," name2")),
                        new Ladder(new RandomLinesGenerator(), 2, new Height("4")),
                        List.of("result1", "result2", "result3"))
        );
    }

    @Test
    @DisplayName("한 명의 플레이어가 사다리 끝까지 이동했는지 테스트한다.")
    void playerMoveEndOfLadder() {
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final Height height = new Height("4");
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(List.of(Rung.BRIDGE, Rung.EMPTY, Rung.BRIDGE));
            }
        };
        final Ladder ladder = new Ladder(linesGenerator, players.getPlayersCount(), height);
        final LadderGame ladderGame = new LadderGame(
                players,
                ladder,
                List.of("O", "X", "O", "O")
        );

        ladderGame.climbLadder();

        assertEquals(players.getPlayers().get(3).getPosition(), new Position(3, 4));
    }

    @Test
    @DisplayName("플레이어 마다 도착한 위치에 있는 실행 결과를 반환하는지 테스트한다.")
    void returnPlayersExecutionResult() {
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(List.of(Rung.EMPTY, Rung.BRIDGE, Rung.EMPTY));
            }
        };
        final Ladder ladder = new Ladder(expectedLinesGenerator, players.getPlayersCount(), new Height("3"));
        final LadderGame ladderGame = new LadderGame(players, ladder, List.of("O","X","O","O"));
        final PlayersResult playersResult = ladderGame.climbLadder();

        assertEquals(playersResult.findItemByPlayerName("name1"), ladderGame.getItems().get(0));
        assertEquals(playersResult.findItemByPlayerName("name2"), ladderGame.getItems().get(2));
        assertEquals(playersResult.findItemByPlayerName("name3"), ladderGame.getItems().get(1));
        assertEquals(playersResult.findItemByPlayerName("name4"), ladderGame.getItems().get(3));
    }
}
