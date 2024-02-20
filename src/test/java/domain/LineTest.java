package domain;

import domain.point.PointGenerator;
import domain.point.strategy.FakePointGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("가로 라인이 연속되는 포인트는 생성되지 않는다")
    void createLineSuccessWithNoneSerialPoints() {
        int playerCount = 4;
        List<Boolean> points = List.of(true, false, true);
        PointGenerator pointGenerator = new FakePointGenerator(points);

        Line line = new Line(pointGenerator.generate(playerCount - 1));
        Assertions.assertThat(line.getPoints()).containsExactlyElementsOf(points);
    }
}
