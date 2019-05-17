package laddergame.domain.ladder;

import laddergame.domain.Constant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @Test
    public void 라인의_너비가_1일때() {
        line = new Line(1);
        assertThat(line.findRoute(1)).isEqualTo(Direction.keep());
    }

    @Test
    public void 라인의_너비가_2일때() {
        line = new Line(2);
        assertThat(line.findRoute(1)).isEqualTo(Direction.keep());
        assertThat(line.findRoute(2)).isEqualTo(Direction.keep());

        line.connect(1);
        //          |------|
        assertThat(line.findRoute(1)).isEqualTo(Direction.right());
        assertThat(line.findRoute(2)).isEqualTo(Direction.left());
    }
}
