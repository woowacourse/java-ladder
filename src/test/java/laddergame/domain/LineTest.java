package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 라인이_제대로_생성되는지_테스트() {
        Line line = new Line(2, new AlwaysCreateRule());

        assertThat(line).isEqualTo(new Line(Arrays.asList(false, true, false)));
    }

    @Test
    void 왼쪽에_발판이_있는_경우_발판_생성_불가() {
        Line line = new Line(Arrays.asList(false, true, false, false));

        assertThat(line.canAddScaffold(2)).isFalse();
    }

    @Test
    void 오른쪽에_발판이_있는_경우_발판_생성_불가() {
        Line line = new Line(Arrays.asList(false, false, true, false));

        assertThat(line.canAddScaffold(1)).isFalse();
    }

    @Test
    void 양쪽에_발판이_없는_경우_발판_생성_불가() {
        Line line = new Line(Arrays.asList(false, false, false, false));

        assertThat(line.canAddScaffold(1)).isTrue();
    }

    @Test
    void 왼쪽에서_오른쪽으로_이동하는_경우() {
        Line line = new Line(Arrays.asList(false, true, false));

        assertThat(line.moveNextPoint(0)).isEqualTo(1);
    }

    @Test
    void 오른쪽에서_왼쪽으로_이동하는_경우() {
        Line line = new Line(Arrays.asList(false, true, false));

        assertThat(line.moveNextPoint(1)).isEqualTo(0);
    }

    @Test
    void 직진하는_경우() {
        Line line = new Line(Arrays.asList(false, false, false));

        assertThat(line.moveNextPoint(0)).isEqualTo(0);
    }

    @Test
    void 포인트가_범위를_벗어났을때_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(Arrays.asList(false, true, false));
            line.moveNextPoint(3);
        });
    }
}