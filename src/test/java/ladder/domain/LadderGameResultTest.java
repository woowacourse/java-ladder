package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        List<Player> players = new ArrayList<>(Arrays.asList(
                new Player("pobi"),
                new Player("denis"),
                new Player("gorae"),
                new Player("sean"),
                new Player("ddugi")));
        String[] prizes = {"1000", "2000", "3000", "4000", "꽝"};
        List<Line> lines = new ArrayList<>(Arrays.asList(
                new Line(new Direction[]{Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT}),
                new Line(new Direction[]{Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT}),
                new Line(new Direction[]{Direction.STRAIGHT, Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT})));

        Ladder ladder = new Ladder(lines);
        ladderGame = new LadderGame(ladder, players, prizes);
    }

    @Test
    void 게임_결과() {
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get(new Player("pobi"))).isEqualTo("1000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("denis"))).isEqualTo("2000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("gorae"))).isEqualTo("4000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("sean"))).isEqualTo("3000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("ddugi"))).isEqualTo("꽝");
    }
}
