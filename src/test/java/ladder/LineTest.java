package ladder;

import ladder.model.CustomLinePointsGenerator;
import ladder.model.Line;
import ladder.model.LinePointsGenerator;
import ladder.model.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    void 겹치는_가로라인_예외발생() {
        LinePointsGenerator linePointsGenerator = new CustomLinePointsGenerator(Arrays.asList(true, false, false, true, true));
        assertThrows(IllegalArgumentException.class, () -> new Line(linePointsGenerator.generatePoints()));
    }

    @Test
    void 겹치지_않는_가로라인_확인() {
        LinePointsGenerator linePointsGenerator = new CustomLinePointsGenerator(Arrays.asList(true, false, true, false, true));
        assertDoesNotThrow(() -> new Line(linePointsGenerator.generatePoints()));
    }

    @Test
    void 한_Line에서_가로라인이_있어_이동했을_때_Player의_Position_변경_확인() {
        LinePointsGenerator linePointsGenerator = new CustomLinePointsGenerator(Arrays.asList(true, false, true, false, true));
        Line line = new Line(linePointsGenerator.generatePoints());
        Player player = new Player("bmo", 0);
        line.move(player);
        assertThat(player.getPosition()).isEqualTo(1);
    }

}
