package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        List<Player> players = Arrays.asList(
                new Player("pobi"),
                new Player("denis"),
                new Player("gorae"),
                new Player("sean"),
                new Player("ddugi"));
        List<Prize> prizes = Arrays.asList(
                new Prize("1000"),
                new Prize("2000"),
                new Prize("3000"),
                new Prize("4000"),
                new Prize("꽝"));
        List<Line> lines = Arrays.asList(
                new Line(new Direction[]{Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT}),
                new Line(new Direction[]{Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT}));

        Ladder ladder = new Ladder(lines);
        ladderGame = new LadderGame(ladder, players, prizes);
    }

    @Test
    void 게임_결과() {
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get(new Player("pobi")))
                .isEqualTo(new Prize("1000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("denis")))
                .isEqualTo(new Prize("2000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("gorae")))
                .isEqualTo(new Prize("4000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("sean")))
                .isEqualTo(new Prize("3000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("ddugi")))
                .isEqualTo(new Prize("꽝"));
    }
}
