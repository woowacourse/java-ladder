package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("높이는 1이상 10이하가 아니면 예외를 던진다.")
    void throws_exception_when_invalidate_range_of_height(int height) {
        // when & then
        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 최소 1이상 최대 10이하입니다.");
    }
}
