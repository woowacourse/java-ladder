package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 다음엔_무조건_트루6() {
        List<Boolean> testLine = (new Line(5)).getHorizon();
        for (int i = 0; i < testLine.size() - 1; i++) {
            assertThat(testLine.get(i) && testLine.get(i + 1)).isEqualTo(false);
        }
    }
}
