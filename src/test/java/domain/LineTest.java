package domain;

import helper.StubImpossiblePointGenerator;
import helper.StubPossiblePointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("건널 수 있는 다리가 추가되는지 확인")
    void addPossiblePoints() {
        Line line = new Line(2, new StubPossiblePointGenerator());

        assertThat(line.getPoints()).containsExactly(true);
    }

    @Test
    @DisplayName("건널 수 없는 다리가 추가되는지 확인")
    void addImpossiblePoints() {
        Line line = new Line(3, new StubImpossiblePointGenerator());

        assertThat(line.getPoints()).containsExactly(false, false);
    }

    @Test
    @DisplayName("연속적으로 생성된 다리가 없는지 확인")
    void checkSuccessivePoints() {
        Line line = new Line(3, new RandomPointGenerator());
        List<Boolean> points = line.getPoints();

        for (int index = 0; index < points.size() - 1; index++) {
            check(points, index);
        }
    }

    private void check(List<Boolean> points, int index) {
        if (points.get(index)) {
            assertThat(points.get(index)).isNotEqualTo(points.get(index + 1));
        }
    }

    @Test
    @DisplayName("올바른(LEFT, RIGHT, STRAIGHT) Direction 반환하는지 확인")
    void getDirection() {
        Line line = new Line(3, new StubPossiblePointGenerator());

        assertThat(line.getDirection(0)).isEqualTo(Direction.RIGHT);
        assertThat(line.getDirection(1)).isEqualTo(Direction.LEFT);
        assertThat(line.getDirection(2)).isEqualTo(Direction.STRAIGHT);
    }
}
