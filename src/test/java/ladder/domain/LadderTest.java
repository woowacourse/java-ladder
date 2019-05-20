package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class LadderTest {
    List<Line> lines;
    Ladder ladder;
    LineResult result;
    Players players;
    Items items;

    @BeforeEach
    void setUp() {
        lines = new ArrayList<>();
        lines.add(Line.newBuilder().start(true).add(false).add(false).add(true).end());
        lines.add(Line.newBuilder().start(false).add(true).add(false).add(true).end());
        lines.add(Line.newBuilder().start(false).add(false).add(true).add(false).end());
        ladder = Ladder.newBuilder(lines);
        result = LineResult.newBuilder(Arrays.asList(3, 0, 1, 2, 4));
        players = Players.newBuilder("pobi, hello, mynam, is, haha");
        items = Items.newBuilder("pass, 1000, 2000, star, pass", players.size());
    }

    @Test
    void create_만들기_자동() {
        Ladder ladder = Ladder.newBuilder(5, 5);
        System.out.println(ladder.draw());
    }

    @Test
    void create_만들기_수동() {
        assertThat(ladder).isEqualTo(Ladder.newBuilder(lines));
    }

    @Test
    void draw_그림그리기() {
        String fString = "|     ";
        String tString = "|-----";
        StringJoiner shapes = new StringJoiner("\n");
        shapes.add(tString + fString + fString + tString + fString);
        shapes.add(fString + tString + fString + tString + fString);
        shapes.add(fString + fString + tString + fString + fString);
        assertThat(ladder.draw(tString, fString)).isEqualTo(shapes.toString());
        System.out.println(shapes.toString());
    }

    @Test
    void execute_실행() {
        assertThat(ladder.executeResult()).isEqualTo(result);
    }

    @Test
    void 결과_매핑_확인() {
        LadderResult ladderResult = LadderResult.newBuild(players, items, ladder.executeResult());
        System.out.println(ladder.draw());
        System.out.println(ladderResult.findMatchItem("all"));
    }

    @Test
    void LadderResult_나오게하기() {
        LadderResult ladderResult = LadderResult.newBuild(players, items, ladder.executeResult());
        assertThat(ladder.makeResult(players, items)).isEqualTo(ladderResult);
    }

    @Test
    void 이름_하나_임의로() {
        Ladder ladder = Ladder.newBuilder(1, 1);
    }
}
