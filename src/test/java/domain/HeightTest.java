package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "20"})
    @DisplayName("Height 생성 성공: 경계값(1, 20)")
    void test_ok(String height) {
        assertThat(Height.from(height).getHeight())
            .isEqualTo(Integer.parseInt(height));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "21"})
    @DisplayName("Height 생성 실패: 경계값(-1, 0, 21)")
    void test_exception_outOfRange(String height) {
        assertThatThrownBy(() -> Height.from(height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 이상 20 이하의 숫자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "a1"})
    @DisplayName("Height 생성 실패: 비허용 문자 입력")
    void test_exception_nonNumeric(String height) {
        assertThatThrownBy(() -> Height.from(height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자만 입력 가능합니다.");
    }
}
