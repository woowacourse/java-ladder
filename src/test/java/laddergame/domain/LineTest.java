package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 라인이_제대로_생성되는지_테스트() {
        Line line = new Line(2, new AlwaysCreateRule());
        List<Point> points = Arrays.asList(new Point(false, true),
                new Point(true, false));

        assertThat(line).isEqualTo(new Line(points));
    }

    @Test
    void 위치_범위를_벗어났을때_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(2, new AlwaysCreateRule());
            line.moveNextPoint(3);
        });
    }
}