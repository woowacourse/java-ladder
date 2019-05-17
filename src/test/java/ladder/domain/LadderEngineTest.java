package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderEngineTest {
    private Ladder ladder;
    private Players playersBeforeGame, playersAfterGame;

    @BeforeEach
    void setup() {
        Position.MAX = 2;

        Point first = Point.first(true);
        Point next = first.next(false);
        Line line1 = new Line(Arrays.asList(first, next, next.last()));

        first = Point.first(false);
        next = first.next(true);
        Line line2 = new Line(Arrays.asList(first, next, next.last()));

        ladder = new Ladder(Arrays.asList(line1, line2));

        List<Player> players = Arrays.asList(new Player("pobi", new Position(0)), new Player("crong", new Position(1)), new Player("honux", new Position(2)));
        playersBeforeGame = new Players(players);

        players = Arrays.asList(new Player("pobi", new Position(2)), new Player("crong", new Position(0)), new Player("honux", new Position(1)));
        playersAfterGame = new Players(players);
    }

    @Test
    void playLadderGameTest() {
        LadderEngine ladderEngine = new LadderEngine(ladder, playersBeforeGame);
        assertThat(ladderEngine.playLadderGame()).isEqualTo(playersAfterGame);
    }
}
