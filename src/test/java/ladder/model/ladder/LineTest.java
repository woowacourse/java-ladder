package ladder.model.ladder;

import ladder.model.linepointsgenerator.impl.CustomLinePointsGenerator;
import ladder.model.linepointsgenerator.LinePointsGenerator;
import ladder.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 한_Line에서_가로라인이_있어_이동했을_때_Player의_Position_변경_확인() {
        LinePointsGenerator linePointsGenerator = new CustomLinePointsGenerator(Arrays.asList(new Point(true), new Point(false), new Point(true)));
        Line line = new Line(linePointsGenerator.generatePoints());
        Player player = new Player("bmo", 0);
        line.move(player);
        assertThat(player.getPosition()).isEqualTo(1);
    }
}
