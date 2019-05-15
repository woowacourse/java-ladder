package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 생성자확인() {
        Line line = new Line(Arrays.asList(false, true, false));
        assertThat(line).isEqualTo(new Line(Arrays.asList(false, true, false)));
    }
}
