package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void 사다리의_높이가_최소_높이보다_작거나_최대_높이보다_큰_경우_예외가_발생한다(int height) {
        // when & then
        assertThatThrownBy(() -> new Height(height))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 50이하의 높이만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 50})
    void 사다리의_높이가_유효범위_이내이면_예외가_발생하지_않는다(int height) {
        // when & then
        assertThatCode(() -> new Height(height))
                .doesNotThrowAnyException();
    }
}
