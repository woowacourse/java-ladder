package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private Line line;
    private Record record;

    @Test
    void 움직임_테스트_false_false() {
        record = new Record(new ArrayList<>(Arrays.asList(0, 1, 2)));
        Point point1 = new Point(false, 0, false);
        Point point2 = new Point(false, 1, false);
        Point point3 = new Point(false, 2, false);
        line = new Line(Arrays.asList(point1, point2, point3));

        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(0, 1, 2)));
    }

    @Test
    void 움직임_테스트_true_false() {
        record = new Record(new ArrayList<>(Arrays.asList(0, 1, 2)));
        Point point1 = new Point(false, 0, true);
        Point point2 = new Point(true, 1, false);
        Point point3 = new Point(false, 2, false);
        line = new Line(Arrays.asList(point1, point2, point3));

        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(1, 0, 2)));
    }

    @Test
    void 움직임_테스트_false_true() {
        record = new Record(new ArrayList<>(Arrays.asList(0, 1, 2)));
        Point point1 = new Point(false, 0, false);
        Point point2 = new Point(false, 1, true);
        Point point3 = new Point(true, 2, false);
        line = new Line(Arrays.asList(point1, point2, point3));

        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(0, 2, 1)));
    }
}
