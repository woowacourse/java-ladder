package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("사람 이름 길이가 부적절(1 미만 5 초과)하면 예외 발생")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_LENGTH_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "!@#$%", "가나다라마"})
    @DisplayName("사람 이름이 영문 대소문자가 아니면 예외 발생")
    void validateNameCharacters(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_CHARACTER.getMessage());
    }
}