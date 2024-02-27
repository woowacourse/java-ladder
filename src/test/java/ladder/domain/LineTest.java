package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private final PointsGenerator pointsGenerator = size -> new ArrayList<>(
            List.of(Point.ON, Point.ON, Point.ON, Point.ON)
    );

    @Test
    @DisplayName("라인에는 사람의 수 - 1 만큼 좌표가 있다.")
    void createLine() {
        // given
        int personCount = 5;

        // when
        Line line = new Line(personCount, pointsGenerator);
        int pointsSize = line.getPoints().size();

        // then
        assertThat(pointsSize).isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("랜덤으로 생성한 사다리 라인을 겹치지 않도록 수정한다.")
    void createNonOverlappingLine() {
        // given
        int personCount = 5;

        // when
        Line line = new Line(personCount, pointsGenerator);

        // then
        assertThat(line.getPoints()).isEqualTo(List.of(Point.ON, Point.OFF, Point.ON, Point.OFF));
    }

    @Test
    @DisplayName("사다리가 오른쪽으로 연결되어 있다면 오른쪽으로 내려온다.")
    public void rideRight() {
        // given
        Line line = new Line(5, pointsGenerator);

        // when
        int positionIndex = line.ride(0);

        // then
        assertThat(positionIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리가 왼쪽으로 연결되어 있다면 왼쪽으로 내려온다.")
    public void rideLeft() {
        // given
        Line line = new Line(5, pointsGenerator);

        // when
        int position = line.ride(1);

        // then
        assertThat(position).isEqualTo(0);
    }
}
