package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {


    @Test
    @DisplayName("")
    void line() {
        new Line(4);
    }

    @Test
    @DisplayName("")
    void create_line() {
        Line line = new Line(4);
        assertThat(line.getPointsSize()).isEqualTo(3);
    }
}
