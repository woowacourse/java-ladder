package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 사다리_높이가_1_미만이면_예외(int value) {
        assertThatThrownBy(() -> new LadderHeight(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 높이는 1 이상이어야 합니다.");
    }
}
