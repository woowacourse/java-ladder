package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 발판을_놓을수_있는지_테스트() {
        Line line = new Line(Arrays.asList(Point.STRAIGHT, Point.RIGHT, Point.LEFT));
        Line line2 = new Line(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT, Point.STRAIGHT));
        Line line3 = new Line(Arrays.asList(Point.RIGHT, Point.LEFT, Point.STRAIGHT, Point.STRAIGHT));

        assertThat(line.canAddScaffold(1)).isFalse();
        assertThat(line2.canAddScaffold(1)).isTrue();
        assertThat(line3.canAddScaffold(2)).isTrue();
    }

    @Test
    void 발판이_제대로_놓아지는지_테스트() {
        Line line = new Line(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT, Point.STRAIGHT));
        Line line1 = new Line(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT, Point.STRAIGHT));

        line.addScaffold(1);
        line1.addScaffold(2);

        assertThat(line).isEqualTo(new Line(Arrays.asList(Point.STRAIGHT, Point.RIGHT, Point.LEFT)));
        assertThat(line1).isEqualTo(new Line(Arrays.asList(Point.STRAIGHT, Point.RIGHT, Point.LEFT)));
    }

    @Test
    void 빈_발판이_올바르게_생성되는지_테스트() {
        Line line = new Line(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT));

        assertThat(new Line(2)).isEqualTo(line);
    }

    @Test
    void 제대로_이동되는지_테스트() {
        Line line1 = new Line(Arrays.asList(Point.RIGHT, Point.LEFT));
        Line line2 = new Line(Arrays.asList(Point.STRAIGHT, Point.STRAIGHT));

        assertThat(line1.moveNextPoint(0)).isEqualTo(1);
        assertThat(line1.moveNextPoint(1)).isEqualTo(0);
        assertThat(line2.moveNextPoint(0)).isEqualTo(0);
        assertThat(line2.moveNextPoint(1)).isEqualTo(1);
    }

    @Test
    void 포인트가_범위를_벗어났을때_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(Arrays.asList(Point.RIGHT, Point.LEFT));
            line.moveNextPoint(3);
        });
    }
}