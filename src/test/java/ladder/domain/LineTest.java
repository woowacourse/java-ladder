package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 가로줄이_있나요() {
        Line line = new Line(Arrays.asList(true, false, true, false, true));
        assertThat(line.getHorizon()).isEqualTo(Arrays.asList(true, false, true, false, true));
    }
}
