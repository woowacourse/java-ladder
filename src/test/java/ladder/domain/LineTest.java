package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 겹치는_라인_에러_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(Arrays.asList(
                        new PointsTuple(Arrays.asList(false, true)),
                        new PointsTuple(Arrays.asList(true, true)),
                        new PointsTuple(Arrays.asList(true, false)))));
    }

    @Test
    void 겹치지_않는_라인_테스트() {
        assertDoesNotThrow(() -> new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)),
                new PointsTuple(Arrays.asList(false, false)))));
        assertDoesNotThrow(() -> new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, false)),
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)))));
        assertDoesNotThrow(() -> new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, false)),
                new PointsTuple(Arrays.asList(false, false)),
                new PointsTuple(Arrays.asList(false, false)))));
    }

    @Test
    void 오른쪽_이동_테스트() {
        Line line = new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)),
                new PointsTuple(Arrays.asList(false, false))));
        int position = 0;
        assertThat(line.determineDirection(position).move(position)).isEqualTo(Direction.RIGHT.move(position));
    }

    @Test
    void 왼쪽_이동_테스트() {
        Line line = new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)),
                new PointsTuple(Arrays.asList(false, false))));
        int position = 1;
        assertThat(line.determineDirection(position).move(position)).isEqualTo(Direction.LEFT.move(position));
    }

    @Test
    void 가운데_이동_테스트() {
        Line line = new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)),
                new PointsTuple(Arrays.asList(false, false))));
        int position = 2;
        assertThat(line.determineDirection(position).move(position)).isEqualTo(Direction.STRAIGHT.move(position));
    }
}
