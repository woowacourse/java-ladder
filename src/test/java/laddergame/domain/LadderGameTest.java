package laddergame.domain;

import laddergame.util.LinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 게임")
public class LadderGameTest {

    @Test
    @DisplayName("한 명의 플레이어가 사다리 끝까지 이동했는지 테스트한다.")
    void playerMoveEndOfLadder() {
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final Height height = new Height("4");
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public Lines generate(int width) {
                return new Lines(List.of(Line.BRIDGE, Line.EMPTY, Line.BRIDGE));
            }
        };
        final Ladder ladder = new Ladder(linesGenerator, players.getPlayersCount(), height);
        final LadderGame ladderGame = new LadderGame(
                players,
                ladder,
                new ResultItems(List.of("O","O","X","O"), players.getPlayersCount()));

        ladderGame.climb();

        assertTrue(players.getPlayers().get(3).getPosition().equals(new Position(3, 4)));
    }

    @Test
    @DisplayName("플레이어 마다 도착한 위치에 있는 실행 결과를 반환하는지 테스트한다.")
    void returnPlayersExecutionResult() {
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final Height height = new Height("3");
        final ResultItems resultItems = new ResultItems(List.of("a","b","c","d"), players.getPlayersCount());
        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Lines generate(int width) {
                return new Lines(List.of(Line.EMPTY, Line.BRIDGE, Line.EMPTY));
            }
        };
        final Ladder ladder = new Ladder(expectedLinesGenerator, players.getPlayersCount(), height);
        final LadderGame ladderGame = new LadderGame(players, ladder, resultItems);

        ladderGame.climb();
        ladderGame.calculatePlayersItem();

        assertEquals(players.getPlayers().get(0).getItem(), resultItems.findByIndex(0));
        assertEquals(players.getPlayers().get(1).getItem(), resultItems.findByIndex(2));
        assertEquals(players.getPlayers().get(2).getItem(), resultItems.findByIndex(1));
        assertEquals(players.getPlayers().get(3).getItem(), resultItems.findByIndex(3));
    }
}
