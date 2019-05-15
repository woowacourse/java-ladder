package laddergame.domain;

import laddergame.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @BeforeEach
    public void setUp() {
        line = new Line(4);
    }

    @Test
    public void 라인에_선을_그리는지_검사() {
        assertThat(line.makeTrueOrFalse(1)).isTrue();
    }

    @Test
    public void 라인에_선을_그리지_않는지_검사() {
        assertThat(line.makeTrueOrFalse(0)).isFalse();
    }

    @Test
    public void 선의_연결_여부를_List에_추가() {
        assertThat(line.makeTrueOrFalse(0)).isFalse();
    }

    @Test
    void test() {
        line.printPoints();
    }
}
