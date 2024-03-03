package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private final RandomPointsGenerator testPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.ON, Point.OFF, Point.ON, Point.OFF);
        }
    };

    @Test
    @DisplayName("입력 받은 만큼 좌표를 생성한다.")
    void line_InputNumber_hasEqualSize() {
        // when
        List<Point> points = new RandomPointsGenerator().generate(4);
        Line line = new Line(points);

        // then
        assertThat(line.getPoints()).hasSize(4);
    }

    @Test
    @DisplayName("사다리가 오른쪽으로 연결되어 있다면 오른쪽으로 내려온다.")
    public void ride_HasRightPoint_PositionPlusOne() {
        // given
        List<Point> points = testPointsGenerator.generate(4);
        Line line = new Line(points);

        // when
        int positionIndex = line.ride(0);

        // then
        assertThat(positionIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리가 왼쪽으로 연결되어 있다면 왼쪽으로 내려온다.")
    public void ride_HasLeftPoint_PositionMinusOne() {
        // given
        List<Point> points = testPointsGenerator.generate(4);
        Line line = new Line(points);

        // when
        int position = line.ride(1);

        // then
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("사다리가 없는 위치라면 예외가 발생한다.")
    public void ride_HasNoneLine_ExceptionThrown() {
        // given
        List<Point> points = testPointsGenerator.generate(4);
        Line line = new Line(points);

        // when & then
        assertThatThrownBy(() -> line.ride(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
