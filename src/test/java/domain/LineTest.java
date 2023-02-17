package domain;

import helper.StubImpossibleDigitsGenerator;
import helper.StubPossibleDigitsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {


    @Test
    @DisplayName("Line 생성 확인")
    void line() {
        new Line(4, new RandomDigitsGenerator());
    }

    @Test
    @DisplayName("건널 수 있는 다리가 추가되는지 확인")
    void addPossiblePoints() {
        Line line = new Line(2, new StubPossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(true);
    }

    @Test
    @DisplayName("건널 수 없는 다리가 추가되는지 확인")
    void addImpossiblePoints() {
        Line line = new Line(3, new StubImpossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(false, false);
    }

    @Test
    @DisplayName("연속적으로 생성된 다리가 없는지 확인")
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
