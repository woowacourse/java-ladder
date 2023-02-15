package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

public class LineTest {

    @Test
    @DisplayName("연속되는 선이 없게 라인을 생성한다.")
    void generateLineTest() {
        BooleanGenerator booleanGenerator = new IntendedBooleanGenerator();

        Line line = new Line(4, booleanGenerator);
        List<Boolean> lineStatus = line.getLineStatus();

        Assertions.assertThat(lineStatus).containsExactly(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
    }

    class IntendedBooleanGenerator implements BooleanGenerator {

        @Override
        public Boolean generate() {
            return Boolean.TRUE;
        }
    }
}
