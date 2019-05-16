package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void 게임_결과() {
        String[] names = {"pobi","denis","kim","gorae"};
        List<Line> lines= new ArrayList<>();
        lines.add(new Line(new int[] {0,0,1,2}));
        lines.add(new Line(new int[] {1,2,1,2}));
        lines.add(new Line(new int[] {0,1,2,0}));
        lines.add(new Line(new int[] {1,2,0,0}));

        Ladder ladder = new Ladder(names,lines);

        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getLadderResultForUserIndex()).containsExactly(2,1,0,3);
    }
}
