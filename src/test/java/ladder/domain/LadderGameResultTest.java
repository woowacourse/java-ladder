package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void 게임_결과() {
        String[] names = {"pobi","denis","kim","gorae"};
        String[] prizes = {"1000", "2000", "3000", "꽝"};
        List<Line> lines= new ArrayList<>();
        lines.add(new Line(new int[] {0,0,1,2}));
        lines.add(new Line(new int[] {1,2,1,2}));
        lines.add(new Line(new int[] {0,1,2,0}));
        lines.add(new Line(new int[] {1,2,0,0}));

        Ladder ladder = new Ladder(names ,lines);

        LadderGame ladderGame = new LadderGame(ladder, names, prizes);
        LadderGameResult ladderGameResult = ladderGame.start();

        assertThat(ladderGameResult.getNameToPrize().get("pobi")).isEqualTo("3000");
        assertThat(ladderGameResult.getNameToPrize().get("denis")).isEqualTo("2000");
        assertThat(ladderGameResult.getNameToPrize().get("kim")).isEqualTo("1000");
        assertThat(ladderGameResult.getNameToPrize().get("gorae")).isEqualTo("꽝");
    }

    @Test
    void 게임_결과1() {
        String[] names = {"pobi","kim","abc","def","ggg"};
        String[] prizes = {"1000", "2000", "3000","4000", "꽝"};
        List<Line> lines= new ArrayList<>();
        lines.add(new Line(new int[] {1,2,1,2,0}));
        lines.add(new Line(new int[] {0,1,2,1,2}));
        lines.add(new Line(new int[] {0,1,2,1,2}));
        lines.add(new Line(new int[] {0,0,1,2,0}));
        lines.add(new Line(new int[] {0,1,2,1,2}));
        lines.add(new Line(new int[] {1,2,1,2,0}));
        lines.add(new Line(new int[] {1,2,1,2,0}));

        Ladder ladder = new Ladder(names ,lines);

        LadderGame ladderGame = new LadderGame(ladder, names, prizes);
        LadderGameResult ladderGameResult = ladderGame.start();

//        assertThat(ladderGameResult.getNameToPrize().get("pobi")).isEqualTo("3000");
//        assertThat(ladderGameResult.getNameToPrize().get("abc")).isEqualTo("2000");
        assertThat(ladderGameResult.getNameToPrize().get("kim")).isEqualTo("1000");
//        assertThat(ladderGameResult.getNameToPrize().get("def")).isEqualTo("꽝");
//        assertThat(ladderGameResult.getNameToPrize().get("ggg")).isEqualTo("4000");
    }
}
