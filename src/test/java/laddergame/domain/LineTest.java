package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 그냥_발판을_놓을수_있는지_테스트() {
        Line line = new Line(Arrays.asList(false, false, true, false));
        Line line2 = new Line(Arrays.asList(false, false, false));

        assertThat(line.canAddScaffold(1)).isFalse();
        assertThat(line2.canAddScaffold(1)).isTrue();
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
        Line line = new Line(Arrays.asList(true, false));
        final int point = 0;
        assertThat(line.nextPoint(point)).isEqualTo(1);
    }
}