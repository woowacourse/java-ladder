package domain;

import helper.StubImpossibleDigitsGenerator;
import helper.StubPossibleDigitsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {


    @Test
    @DisplayName("")
    void line() {
        new Line(4, new RandomDigitsGenerator());
    }

    @Test
    @DisplayName("")
    void create_line() {
        Line line = new Line(4, new RandomDigitsGenerator());

        assertThat(line.getPointsSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("")
    void addPossiblePoints() {
        Line line = new Line(3, new StubPossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(true, true);
    }

    @Test
    @DisplayName("")
    void addImpossiblePoints() {
        Line line = new Line(3, new StubImpossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(false, false);
    }
}
