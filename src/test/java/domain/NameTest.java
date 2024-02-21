package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("사람 이름 길이 검증")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_LENGTH_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "!@#$%", "가나다라마"})
    @DisplayName("사람 이름 구성 문자 검증")
    void validateNameCharacters(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_CHARACTER.getMessage());
    }
}