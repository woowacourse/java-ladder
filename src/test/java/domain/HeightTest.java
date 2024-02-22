package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "20"})
    @DisplayName("사다리 높이 생성 성공: 1부터 20까지 가능")
    void test_ok(String height) {
        assertThatCode(() -> new Height(height))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "21"})
    @DisplayName("사다리 높이 생성 실패: 높이 경계값 -1, 0, 21")
    void test_exception_outOfRange(String height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "a1"})
    @DisplayName("사다리 높이 생성 실패: 문자 입력 경우")
    void test_exception_nonNumeric(String height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
