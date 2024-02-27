package domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "10000"})
    @DisplayName("결과는 정해진 글자 수 범위 안에서 정상적으로 생성된다.")
    void validCreationTest(String result) {
        assertDoesNotThrow(() -> new Result(result));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @NullAndEmptySource
    @DisplayName("결과가 정해진 글자 수 범위를 벗어나는 경우, 예외를 발생한다.")
    void exceedingBytesCreationTest(String result) {
        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 1글자에서 5글자 사이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a b", "!", "abc;"})
    @DisplayName("결과가 한글, 영어 대소문자, 숫자로 이루어지지 않은 경우 예외를 발생한다.")
    void invalidCharacterCreationTest(String result) {
        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 알파벳 대소문자, 숫자나 한글로 이루어져야 합니다.");
    }
}
