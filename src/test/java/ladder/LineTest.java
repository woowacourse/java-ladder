package ladder;

import ladder.model.Line;
import ladder.model.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {
    @Test
    void 플레이어수_보다_1작은_Line이_만들어지는지_확인() {
//        assertThat(new Line(5).lineSize()).isEqualTo(4);
    }

    @Test
    void 랜덤_boolean에_따라_생성된_한_라인의_가로라인이_겹치지_않는지_검증() {
        for (int i = 0; i < 1000; i++) {
            assertDoesNotThrow(() -> new Line(5).checkPointsValid());
        }
    }

    @Test
    void 한_Line에서_가로라인이_있어_이동했을_때_Player의_Position_변경_확인() {
        Line line = new Line(2);
        Player player = new Player("bmo",0);
        line.move(player);
        if (line.isTrue(0)) {
            assertThat(player.getPosition()).isEqualTo(1);
        } else {
            assertThat(player.getPosition()).isEqualTo(0);
        }
    }

}
