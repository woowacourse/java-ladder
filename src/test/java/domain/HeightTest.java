package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 20})
    @DisplayName("Height 생성 성공: 경계값(1, 20)")
    void test_ok(int height) {
        assertThat(Height.from(height).getHeight())
            .isEqualTo(height);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 21})
    @DisplayName("Height 생성 실패: 경계값(-1, 0, 21)")
    void test_exception_outOfRange(int height) {
        assertThatThrownBy(() -> Height.from(height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 이상 20 이하의 숫자를 입력해 주세요.");
    }
}
