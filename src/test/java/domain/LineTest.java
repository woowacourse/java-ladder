package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 10, 30, 50})
    @DisplayName("Line의 points 크기는 참가자 수 - 1 이다")
    void validatePointSize_Success(int personCount) {
        Line line = new Line(personCount);
        assertThat(line.getPoints().size()).isEqualTo(personCount - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 51})
    @DisplayName("참가수가 1미안 50초과이면 Line이 생성되지 않고 예외가 발생한다")
    void createLine_Fail(int personCount) {
        assertThatThrownBy(() -> new Line(personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
