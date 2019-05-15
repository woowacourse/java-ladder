package ladder;

import ladder.model.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {
    @Test
    void 플레이어수_보다_1작은_Line이_만들어지는지_확인() {
        assertThat(new Line(5).lineSize()).isEqualTo(4);
    }

    @Test
    void 랜덤_boolean에_따라_생성된_한_라인의_가로라인이_겹치지_않는지_검증() {
        for (int i = 0; i < 1000; i++) {
            assertDoesNotThrow(() -> new Line(5).checkPointsValid());
        }
    }


}
