package domain;

import helper.StubImpossibleDigitsGenerator;
import helper.StubPossibleDigitsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

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
        Line line = new Line(2, new StubPossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(true);
    }

    @Test
    @DisplayName("")
    void addImpossiblePoints() {
        Line line = new Line(3, new StubImpossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(false, false);
    }

    @Test
    @DisplayName("")
    void checkSuccessivePoints() {
        Line line = new Line(3, new RandomDigitsGenerator());
        List<Boolean> points = line.getPoints();

        for (int index = 0; index < points.size() - 1; index++) {
            check(points, index);
        }
    }

    private static void check(List<Boolean> points, int index) {
        if (points.get(index)) {
            assertThat(points.get(index)).isNotEqualTo(points.get(index + 1));
        }
    }
}
