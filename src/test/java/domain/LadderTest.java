package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 11})
    @DisplayName("사다리 높이 검증")
    void validateLadderHeight(int height) {
        assertThatThrownBy(() -> new Ladder(height, 5))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사다리 높이는 5이상 10 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("사다리 전체 폭 검증")
    void validateLadderWidth(int width) {
        assertThatThrownBy(() -> new Ladder(5, width))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사다리 전체 폭은 2이상 10 이하여야 합니다.");
    }

    @Test
    @DisplayName("사다리 전체 폭 검증")
    void validateRowCount() {
        Ladder ladder = new Ladder(5, 6);
        Assertions.assertThat(ladder.getRows().size())
                .isEqualTo(5);
    }
}