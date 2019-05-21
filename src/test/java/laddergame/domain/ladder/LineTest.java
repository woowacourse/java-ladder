package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private static final int RIGHT_MOVE = 1;
    private static final int LEFT_MOVE = -1;
    private static final int NOT_MOVE = 0;

    private Line line;

    @Test
    public void 라인의_너비가_1일때() {
        line = new Line(1);
        assertThat(line.findRoute(1)).isEqualTo(NOT_MOVE);
    }

    @Test
    public void 라인의_너비가_2일때() {
        line = new Line(2);
        //          |       |
        assertThat(line.findRoute(1)).isEqualTo(NOT_MOVE);
        assertThat(line.findRoute(2)).isEqualTo(NOT_MOVE);

        line.connect(1);
        //          |------|
        assertThat(line.findRoute(1)).isEqualTo(RIGHT_MOVE);
        assertThat(line.findRoute(2)).isEqualTo(LEFT_MOVE);
    }
}
