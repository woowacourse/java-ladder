package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineWidthTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 사다리_라인_폭이_1_미만이면_예외(int value) {
        assertThatThrownBy(() -> new LineWidth(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
