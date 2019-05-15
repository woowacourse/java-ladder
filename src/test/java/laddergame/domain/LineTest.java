package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 객체가_제대로_생성되는지_확인() {
        assertThat(new Line()).isEqualTo(new Line());
    }

    @Test
    void 다음_발판을_놓을수_있는지_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        Line line2 = new Line(Arrays.asList(true, true));

        assertThat(line.canAddTrueScaffold()).isTrue();
        assertThat(line2.canAddTrueScaffold()).isFalse();
    }

    @Test
    void 발판이_제대로_놓아지는지_테스트() {
        Line line = new Line(new ArrayList(Arrays.asList(true, false)));

        assertThat(line.addScaffold(true)).isTrue();
    }
}