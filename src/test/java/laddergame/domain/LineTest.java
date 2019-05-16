package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 발판을_놓을수_있는지_테스트() {
        Line line = new Line(Arrays.asList(false, false, true, false));
        Line line2 = new Line(Arrays.asList(false, false, false));
        Line line3 = new Line(Arrays.asList(false, true, false, false));

        assertThat(line.canAddScaffold(1)).isFalse();
        assertThat(line2.canAddScaffold(1)).isTrue();
        assertThat(line3.canAddScaffold(2)).isFalse();
    }

    @Test
    void 발판이_제대로_놓아지는지_테스트() {
        Line line = new Line(Arrays.asList(false, false, false));
        final int interval = 1;

        line.addScaffold(interval);

        assertThat(line).isEqualTo(new Line(Arrays.asList(false, true, false)));
    }

    @Test
    void 빈_발판이_올바르게_생성되는지_테스트() {
        Line line = new Line(Arrays.asList(false, false, false));

        assertThat(new Line(2)).isEqualTo(line);
    }

    @Test
    void 제대로_이동되는지_테스트() {
        Line line1 = new Line(Arrays.asList(false, true, false));
        Line line2 = new Line(Arrays.asList(false, false, false));

        assertThat(line1.moveNextPoint(0)).isEqualTo(1);
        assertThat(line1.moveNextPoint(1)).isEqualTo(0);
        assertThat(line2.moveNextPoint(0)).isEqualTo(0);
        assertThat(line2.moveNextPoint(1)).isEqualTo(1);
    }

    @Test
    void 포인트가_범위를_벗어났을때_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(Arrays.asList(false, true, false));
            line.moveNextPoint(3);
        });
    }
}