package laddergame.domain;

import laddergame.util.LinesGenerator;
import laddergame.util.RandomLinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderGameTest {

    @Test
    @DisplayName("한 명의 플레이어가 사다리 끝까지 이동했는지 테스트한다.")
    void playerMoveEndOfLadder() {
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final Height height = new Height("4");
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return List.of(Line.BRIDGE, Line.EMPTY, Line.BRIDGE);
            }
        };
        final Ladder ladder = new Ladder(linesGenerator, players.getPlayersCount(), height);
        final LadderGame ladderGame = new LadderGame(players, ladder);

        ladderGame.start();

        assertTrue(players.getPlayers().get(3).getPosition().equals(new Position(3, 4)));
    }
}
