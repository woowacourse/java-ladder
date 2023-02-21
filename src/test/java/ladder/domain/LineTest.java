package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.util.TrueGenerator;

class LineTest {
    @ParameterizedTest(name = "가로 라인이 겹치는 경우는 생성할 수 없다.")
    @ValueSource(ints = {2, 10, 100})
    void createLineTest(int personCount) {
        List<Boolean> line = new Line(personCount, new TrueGenerator()).getLine();
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) == Boolean.TRUE) {
                assertThat(line.get(i + 1)).isEqualTo(Boolean.FALSE);
            }
        }
    }
}
