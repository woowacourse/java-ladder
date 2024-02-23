package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("가로줄이 겹치지 않는 라인이 만들어지는가")
    void non_adjacent_line_created() {
        int width = 5;

        Line line = new Line(width);
        List<Boolean> bridges = line.getBridges();

        for (int current = 1; current < bridges.size(); current++) {
            Boolean beforeBridge = bridges.get(current - 1);
            Boolean currentBridge = bridges.get(current);
            assertThat(beforeBridge && currentBridge).isFalse();
        }
    }

    @Test
    @DisplayName("너비가 0일 때 라인이 안 만들어지는가")
    void non_adjacent_line_with_zero_width_created() {
        int width = 0;

        Line line = new Line(width);
        List<Boolean> bridges = line.getBridges();

        assertThat(bridges).isEqualTo(List.of());
    }
}
