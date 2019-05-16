package laddergame.domain.ladder;

import laddergame.domain.Constant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @Test
    public void 라인의_너비가_1일때() {
        line = new Line(1);
        assertThat(line.findRoute(1)).isEqualTo(Constant.NOT_MOVE);
    }

    @Test
    public void 라인의_너비가_2일때() {
        line = new Line(2);
        assertThat(line.findRoute(1)).isEqualTo(Constant.NOT_MOVE);
        assertThat(line.findRoute(2)).isEqualTo(Constant.NOT_MOVE);

        line.connect(1);
        //          |------|
        assertThat(line.findRoute(1)).isEqualTo(Constant.RIGHT_MOVE);
        assertThat(line.findRoute(2)).isEqualTo(Constant.LEFT_MOVE);
    }
}
