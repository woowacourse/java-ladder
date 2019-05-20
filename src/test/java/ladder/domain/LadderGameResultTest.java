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
        Players players = new Players("pobi,denis,gorae,sean,ddugi");
        Prizes prizes = new Prizes("1000,2000,3000,4000,꽝");

        List<Line> lines = new ArrayList<>(Arrays.asList(
                new Line(new ArrayList<>(Arrays.asList(Direction.RIGHT,Direction.LEFT,Direction.RIGHT,Direction.LEFT,Direction.STRAIGHT))),
                new Line(new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT))),
                new Line(new ArrayList<>(Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT))),
                new Line(new ArrayList<>(Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT))),
                new Line(new ArrayList<>(Arrays.asList(Direction.STRAIGHT, Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT)))
        ));

        Ladder ladder = new Ladder(lines);
        ladderGame = new LadderGame(ladder, players, prizes);
    }

    @Test
    void 게임_결과() {
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get(new Player("pobi"))).isEqualTo(new Prize("1000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("denis"))).isEqualTo(new Prize("2000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("gorae"))).isEqualTo(new Prize("4000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("sean"))).isEqualTo(new Prize("3000"));
        assertThat(ladderGameResult.getNameToPrize().get(new Player("ddugi"))).isEqualTo(new Prize("꽝"));
    }
}
