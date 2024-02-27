import static org.assertj.core.api.Assertions.assertThat;

import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Step;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
//    @Test
//    void goColumnIfExist() {
//        /*
//        a  b  c  d
//        |--|  |  |
//         */
//        LadderGame ladderGame = new LadderGame();
//        int startColumnIndex = 0;
//        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
//
//        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(1);
//    }
//
//    @Test
//    void forwardColumnIfBeforeExist() {
//        /*
//        a  b  c  d
//        |--|  |  |
//         */
//        LadderGame ladderGame = new LadderGame();
//        int startColumnIndex = 1;
//        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
//
//        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(0);
//    }
//
//    @Test
//    void stayColumnIfEmpty() {
//        /*
//        a  b  c  d
//        |--|  |  |
//         */
//        LadderGame ladderGame = new LadderGame();
//        int startColumnIndex = 2;
//        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
//
//        assertThat(ladderGame.playLine(startColumnIndex, line)).isEqualTo(2);
//    }
//
//    @Test
//    void playLines() {
//        /*
//        a  b  c  d
//        |--|  |  |
//        |  |  |--|
//         */
//        LadderGame ladderGame = new LadderGame();
//
//        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));
//        Line line2 = new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EXIST, Step.EMPTY));
//        List<Line> lines = List.of(line1, line2);
//
//        assertThat(ladderGame.playLines(0, lines)).isEqualTo(1);
//        assertThat(ladderGame.playLines(1, lines)).isEqualTo(0);
//        assertThat(ladderGame.playLines(2, lines)).isEqualTo(3);
//        assertThat(ladderGame.playLines(3, lines)).isEqualTo(2);
//    }
//
//    @Test
//    void playPlayers() {
//        /*
//        a  b  c  d
//        |--|  |  |
//        |--|  |--|
//        |  |  |  |
//         */
//        LadderGame ladderGame = new LadderGame();
//        List<String> players = List.of("a", "b", "c", "d");
//
//        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));
//        Line line2 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST, Step.EMPTY));
//        Line line3 = new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY, Step.EMPTY));
//        List<Line> lines = List.of(line1, line2, line3);
//
//        assertThat(ladderGame.playPlayers(lines, players)).containsExactlyInAnyOrderEntriesOf(Map.of(
//                "a", 0,
//                "b", 1,
//                "c", 3,
//                "d", 2
//        ));
//    }
//
//    @Test
//    void getPlayersWithPrize() {
//        /*
//        a  b  c  d
//        |--|  |  |
//        |--|  |--|
//        |  |  |  |
//        A  B  C  D
//         */
//        LadderGame ladderGame = new LadderGame();
//        List<String> players = List.of("a", "b", "c", "d");
//        List<String> prizes = List.of("A", "B", "C", "D");
//
//        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));
//        Line line2 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST, Step.EMPTY));
//        Line line3 = new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY, Step.EMPTY));
//        List<Line> lines = List.of(line1, line2, line3);
//
//        Map<String, Integer> playersWithResultIndex = ladderGame.playPlayers(lines, players);
//
//        assertThat(ladderGame.getPlayersWithPrize(playersWithResultIndex, prizes)).containsExactlyInAnyOrderEntriesOf(Map.of(
//                "a", "A",
//                "b", "B",
//                "c", "D",
//                "d", "C"
//        ));
//    }

    @Test
    void LadderGame() {
         /*
        a  b  c  d
        |--|  |  |
         */
        Line line1 = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY));

        Ladder ladder = new Ladder(List.of(line1));
        Players players = Players.from(List.of("a", "b", "c", "d"));
        List<String> prizes = List.of("A", "B", "C", "D");
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        assertThat(ladderGame.getPlayersWithPrize2()).containsExactlyInAnyOrderEntriesOf(Map.of(
                new Player("a"), "B",
                new Player("b"), "A",
                new Player("c"), "C",
                new Player("d"), "D"
        ));
    }
}
