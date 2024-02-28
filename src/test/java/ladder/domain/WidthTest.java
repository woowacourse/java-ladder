package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void widthConstructTest() {
        Width width = new Width(2);

        assertThat(width.value()).isEqualTo(2);
    }

    @DisplayName("2 미만의 너비를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {1, 0, -1})
    @ParameterizedTest
    void invalidWidthTest(int value) {
        assertThatThrownBy(() -> new Width(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너비는 2 이상이여야 합니다: %d".formatted(value));
    }

    @DisplayName("자신의 값이 입력된 값보다 크면 true를 반환한다.")
    @Test
    void isLargerThanTest() {
        Width width = new Width(3);
        assertAll(
                () -> assertThat(width.isLargerThan(2)).isTrue(),
                () -> assertThat(width.isLargerThan(3)).isFalse()
        );
    }
}
