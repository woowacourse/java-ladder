import static org.assertj.core.api.Assertions.assertThat;

import domain.LadderGame;
import domain.Line;
import domain.Step;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    @Test
    void goIfExist() {
        /*
        a  b  c  d
        |--|  |--|
         */
        LadderGame ladderGame = new LadderGame();
        int column = 0;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));

        assertThat(ladderGame.playLine(column, line)).isEqualTo(1);
    }

    @Test
    void stayIfEmpty() {
        /*
        a  b  c  d
        |--|  |--|
         */
        LadderGame ladderGame = new LadderGame();
        int column = 1;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));

        assertThat(ladderGame.playLine(column, line)).isEqualTo(1);
    }
}
