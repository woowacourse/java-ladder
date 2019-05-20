package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 연속_true_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(Arrays.asList(false, true, true, false));
        });
    }

    @Test
    void 맨처음_이동() {
        Line line = new Line(Arrays.asList(false, false, true, false));
        assertThat(line.move(1)).isEqualTo(1);
        line = new Line(Arrays.asList(false, true, false, false));
        assertThat(line.move(1)).isEqualTo(2);
    }

    @Test
    void 맨끝_이동() {
        Line line = new Line(Arrays.asList(false, true, false, false));
        assertThat(line.move(3)).isEqualTo(3);
        line = new Line(Arrays.asList(false, false, true, false));
        assertThat(line.move(3)).isEqualTo(2);
    }

    @Test
    void 가운데_이동() {
        Line line = new Line(Arrays.asList(false, true, false, false));
        assertThat(line.move(2)).isEqualTo(1);
        line = new Line(Arrays.asList(false, false, false, false));
        assertThat(line.move(2)).isEqualTo(2);
        line = new Line(Arrays.asList(false, false, true, false));
        assertThat(line.move(2)).isEqualTo(3);
    }
}
