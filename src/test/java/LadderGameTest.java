import static org.assertj.core.api.Assertions.assertThat;

import domain.LadderGame;
import domain.Line;
import domain.Step;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    @Test
    void goColumnIfExist() {
        /*
        a  b  c  d
        |--|  |  |
         */
        LadderGame ladderGame = new LadderGame();
        int startColumnIndex = 0;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));

        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(1);
    }

    @Test
    void forwardColumnIfBeforeExist() {
        /*
        a  b  c  d
        |--|  |  |
         */
        LadderGame ladderGame = new LadderGame();
        int startColumnIndex = 1;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));

        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(0);
    }

    @Test
    void stayColumnIfEmpty() {
        /*
        a  b  c  d
        |--|  |  |
         */
        LadderGame ladderGame = new LadderGame();
        int startColumnIndex = 2;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));

        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(2);
    }

    @Test
    void playLines() {
        /*
        a  b  c  d
        |--|  |  |
        |  |  |--|
         */
        LadderGame ladderGame = new LadderGame();

        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));
        Line line2 = new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EXIST, Step.EMPTY));
        List<Line> lines = List.of(line1, line2);

        assertThat(ladderGame.playLines(0, lines)).isEqualTo(1);
        assertThat(ladderGame.playLines(1, lines)).isEqualTo(0);
        assertThat(ladderGame.playLines(2, lines)).isEqualTo(3);
        assertThat(ladderGame.playLines(3, lines)).isEqualTo(2);
    }

    @Test
    void playPlayers() {
        /*
        a  b  c  d
        |--|  |  |
        |--|  |--|
        |  |  |  |
         */
        LadderGame ladderGame = new LadderGame();
        List<String> players = List.of("a", "b", "c", "d");

        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));
        Line line2 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST, Step.EMPTY));
        Line line3 = new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY, Step.EMPTY));
        List<Line> lines = List.of(line1, line2, line3);

        assertThat(ladderGame.playPlayers(lines, players)).containsExactlyInAnyOrderEntriesOf(Map.of(
                "a", 0,
                "b", 1,
                "c", 3,
                "d", 2
        ));
    }
}
