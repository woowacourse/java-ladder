package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 한 층은 ")
class LineTest {
    @Nested
    @DisplayName(" 한 step 이 연결되어 있다면, 왼쪽에서 오른쪽으로 연결된 정보만 보여준다.")
    class LineInformation {

        @Test
        void generateLineTest() {
            BooleanGenerator generator = new FixBooleanGenerator(true, false, true);

            Line line = new Line(generator);

            for (int generateCount = 0; generateCount < 5; generateCount++) {
                line.generateStep();
            }

            assertThat(line.getRightConnectionCondition()).containsExactly(true, false, false, true, false);
        }
    }
}
