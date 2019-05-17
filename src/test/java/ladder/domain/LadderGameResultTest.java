package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void 게임_결과() {
        List<Player> players = new ArrayList<>(Arrays.asList(
                new Player("pobi"),
                new Player("denis"),
                new Player("gorae"),
                new Player("sean"),
                new Player("ddungi")));
        String[] prizes = {"1000", "2000", "3000", "4000", "꽝"};
        List<Line> lines = new ArrayList<>(Arrays.asList(
                new Line(new int[]{1, 2, 1, 2, 0}),
                new Line(new int[]{1, 2, 1, 2, 0}),
                new Line(new int[]{0, 1, 2, 1, 2}),
                new Line(new int[]{0, 1, 2, 1, 2}),
                new Line(new int[]{0, 0, 1, 2, 0})));

        Ladder ladder = new Ladder(lines);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get(new Player("pobi"))).isEqualTo("1000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("denis"))).isEqualTo("2000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("gorae"))).isEqualTo("4000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("sean"))).isEqualTo("3000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("ddungi"))).isEqualTo("꽝");
    }
}
