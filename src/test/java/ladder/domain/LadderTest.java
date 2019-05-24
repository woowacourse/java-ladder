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
        lines.add(Line.newInstance(Arrays.asList(Point.RIGHT, Point.LEFT, Point.STRAIGHT, Point.RIGHT, Point.LEFT)));
        lines.add(Line.newInstance(Arrays.asList(Point.STRAIGHT, Point.RIGHT, Point.LEFT, Point.RIGHT, Point.LEFT)));
        lines.add(Line.newInstance(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT, Point.RIGHT, Point.LEFT, Point.STRAIGHT)));
        ladder = Ladder.newInstance(lines);
        result = LineResult.newInstance(Arrays.asList(3, 0, 1, 2, 4));
        players = Players.newInstance("pobi, hello, mynam, is, haha");
        items = Items.newInstance("pass, 1000, 2000, star, pass", players.size());
    }

    @Test
    void create_만들기_자동() {
        Ladder ladder = Ladder.newInstance(5, 5);
        System.out.println(ladder.draw());
    }

    @Test
    void create_만들기_수동() {
        assertThat(ladder).isEqualTo(Ladder.newInstance(lines));
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
        LadderResult ladderResult = LadderResult.newInstance(players, items, ladder.executeResult());
        System.out.println(ladder.draw());
        System.out.println(ladderResult.findMatchItem("all"));
    }

    @Test
    void LadderResult_나오게하기() {
        LadderResult ladderResult = LadderResult.newInstance(players, items, ladder.executeResult());
        assertThat(ladder.makeResult(players, items)).isEqualTo(ladderResult);
    }


    @Test
    void iter_확인() {
        for (Line line : Ladder.newInstance(4, 5)) {
            for (Point point : line) {
                System.out.print(point);
            }
        }
    }
}
