package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리 높이는 30을 초과할 수 없다.")
    @Test
    void ladderLineSizeNotMoreThan30() {
        int lineSize = 31;
        assertThatThrownBy(() -> {
            new Ladder(lineSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이에 0 이하의 수가 들어올 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void ladderLineSizeNotLessThan30(int lineSize) {
        assertThatThrownBy(() -> {
            new Ladder(lineSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
