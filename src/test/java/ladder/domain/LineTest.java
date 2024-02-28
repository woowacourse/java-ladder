package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private final RandomPointsGenerator testPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.ON, Point.OFF, Point.ON);
        }
    };

    @Test
    @DisplayName("입력 받은 만큼 좌표를 생성한다.")
    void createLine() {
        // when
        List<Point> points = new RandomPointsGenerator().generate(3);
        Line line = new Line(points);

        // then
        assertThat(line.getPoints()).hasSize(3);
    }

    @Test
    @DisplayName("사다리가 오른쪽으로 연결되어 있다면 오른쪽으로 내려온다.")
    public void rideRight() {
        // given
        List<Point> points = testPointsGenerator.generate(3);
        Line line = new Line(points);

        // when
        int positionIndex = line.ride(0);

        // then
        assertThat(positionIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리가 왼쪽으로 연결되어 있다면 왼쪽으로 내려온다.")
    public void rideLeft() {
        // given
        List<Point> points = testPointsGenerator.generate(3);
        Line line = new Line(points);

        // when
        int position = line.ride(1);

        // then
        assertThat(position).isEqualTo(0);
    }
}
