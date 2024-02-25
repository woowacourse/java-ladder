package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("사다리의 높이가 1 미만일 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateTest_WhenHeightIsNotPositive(int value) {

        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("사다리의 높이가 1 이상일 경우 정상적으로 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void validateTest_WhenHeightIsPositive(int value) {
        Height height = new Height(value);

        assertThat(height.getValue()).isEqualTo(value);
    }
}
