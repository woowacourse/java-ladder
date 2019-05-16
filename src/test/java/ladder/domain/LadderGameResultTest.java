package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void 게임_결과1() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("pobi"));
        players.add(new Player("denis"));
        players.add(new Player("gorae"));
        players.add(new Player("sean"));
        players.add(new Player("ddungi"));

        String[] prizes = {"1000", "2000", "3000", "4000", "꽝"};
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(new int[]{1, 2, 1, 2, 0}));
        lines.add(new Line(new int[]{0, 1, 2, 1, 2}));
        lines.add(new Line(new int[]{0, 1, 2, 1, 2}));
        lines.add(new Line(new int[]{0, 0, 1, 2, 0}));

        Ladder ladder = new Ladder(lines);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get(new Player("pobi"))).isEqualTo("2000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("denis"))).isEqualTo("1000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("gorae"))).isEqualTo("3000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("sean"))).isEqualTo("4000");
        assertThat(ladderGameResult.getNameToPrize().get(new Player("ddungi"))).isEqualTo("꽝");
    }
}
