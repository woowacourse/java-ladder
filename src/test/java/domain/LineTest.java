package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("가로줄이 겹치지 않는 라인이 만들어지는가")
    void test() {
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
}
