package result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "10000", "1"})
    @DisplayName("결과가 올바르게 생성된다.")
    void validCreationTest(String name) {
        assertDoesNotThrow(() -> new Result(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @NullAndEmptySource
    @DisplayName("글자 수가 올바르지 않은 경우, 예외를 발생한다.")
    void invalidResultLengthTest(String name) {
        assertThatThrownBy(() -> new Result(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi me", "wow!"})
    @DisplayName("결과가 한글, 영어 대소문자, 숫자로 이루어지지 않으면 예외를 발생한다.")
    void invalidResultPatternTest(String name) {
        assertThatThrownBy(() -> new Result(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
