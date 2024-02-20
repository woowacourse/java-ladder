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
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름의 길이는 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "!@#$%", "가나다라마"})
    @DisplayName("사람 이름 구성 문자 검증")
    void validateNameCharacters(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 알파벳 대소문자로만 이루어져있어야 합니다.");
    }
}