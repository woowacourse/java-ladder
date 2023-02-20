package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import helper.StubImpossibleDigitsGenerator;
import helper.StubPossibleDigitsGenerator;

public class LineTest {
    private final RandomDigitsGenerator randomDigitsGenerator = new RandomDigitsGenerator();

    @Test
    @DisplayName("라인을 생성한다.")
    void create_line() {
        Line line = new Line(3, randomDigitsGenerator);

        assertThat(line.getPointsSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동할 수 있는 포인트를 추가한다.")
    void addPossiblePoints() {
        Line line = new Line(1, new StubPossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(true);
    }

    @Test
    @DisplayName("이동할 수 없는 포인트를 추가한다.")
    void addImpossiblePoints() {
        Line line = new Line(2, new StubImpossibleDigitsGenerator());

        assertThat(line.getPoints()).containsExactly(false, false);
    }

    @Test
    @DisplayName("이동 할 수 있는 포인트가 불연속적인지 확인한다.")
    void checkSuccessivePoints() {
        Line line = new Line(3, randomDigitsGenerator);
        List<Boolean> points = line.getPoints();

        for (int index = 0; index < points.size() - 1; index++) {
            assertNotSuccesivePoints(points, index);
        }
    }

    private void assertNotSuccesivePoints(List<Boolean> points, int index) {
        if (points.get(index)) {
            assertThat(points.get(index)).isNotEqualTo(points.get(index + 1));
        }
    }

}
