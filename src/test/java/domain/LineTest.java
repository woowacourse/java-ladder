package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.LineMaker;

@DisplayName("가로 라인은 ")
class LineTest {

    @DisplayName("연결선을 연속해서 가질 수 없다.")
    @Test
    void generateLineTest() {
        Line line = new Line(new FixedLineMaker(), 5);
        assertThat(line.getPoints()).isEqualTo(List.of(true, false, false, true));
    }

    private class FixedLineMaker implements LineMaker {

        @Override
        public List<Boolean> generateLine(int userCount) {
            return List.of(true, true, false, true);
        }
    }

}