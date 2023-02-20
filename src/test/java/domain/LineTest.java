package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.LineMaker;

@DisplayName("가로 라인은 ")
class LineTest {

    @DisplayName("연결선을 연속해서 가질 수 없다.")
    @Test
    void generateLineTest() {
        Line line = new Line(new FixedLineMaker(), 5);

        List<Boolean> lineConnectionStatus = line.getPoints().stream()
                .map(Point::isConnected)
                .collect(Collectors.toList());

        assertThat(lineConnectionStatus).isEqualTo(List.of(true, false, false, true));
    }

    private class FixedLineMaker implements LineMaker {

        @Override
        public List<Point> generateLine(int userCount) {
            return List.of(new Point(true)
                    , new Point(true)
                    , new Point(false)
                    , new Point(true));
        }
    }

}