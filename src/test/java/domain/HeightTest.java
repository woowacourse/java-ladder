package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("높이는 1이상 10이하가 아니면 예외를 던진다.")
    void throws_exception_when_invalidate_range_of_height(int givenHeight) {
        // when & then
        Assertions.assertThatThrownBy(() -> new Height(givenHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 최소 1이상 최대 10이하입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("높이가 1이상 10이하라면 예외를 던지지 않는다.")
    void throws_not_exception_when_validate_range_of_height(int givenHeight) {
        // given
        Height height = new Height(givenHeight);

        // when & then
        assertThat(height.getHeight()).isEqualTo(givenHeight);

    }
}
