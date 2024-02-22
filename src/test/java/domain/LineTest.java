package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("가로줄이 겹치지 않는 라인이 만들어지는가")
    void create_non_adjacent_line_test() {
        // given
        int width = 5;

        // when
        Line line = new Line(width);
        List<Boolean> bridges = line.getBridges();

        // then
        for (int x = 0; x < bridges.size() - 1; x++) {
            Boolean currentBridge = bridges.get(x);
            Boolean nextBridge = bridges.get(x + 1);
            assertThat(currentBridge && nextBridge).isFalse();
        }
    }

    @Test
    @DisplayName("너비가 0일 때 라인이 안 만들어지는가")
    void create_non_adjacent_line_with_zero_width() {
        // given
        int width = 0;

        // when
        Line line = new Line(width);
        List<Boolean> bridges = line.getBridges();

        // then
        assertThat(bridges).isEqualTo(List.of());
    }
}
