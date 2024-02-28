package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @Test
    @DisplayName("사람 이름은 5글자 이하다.")
    void isNameValidLength() {
        String name = "pobip";

        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("사람 이름이 5글자를 넘을 경우 예외가 발생한다.")
    void isNameOverMaxLengthLimit() {
        String name = "pobipo";

        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @Test
    @DisplayName("이름은 2글자 이상이다.")
    void isValidName() {
        String name = "po";

        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("이름이 2글자 미만일 경우 예외가 발생한다.")
    void isNameUnderMinLengthLimit() {
        String name = "p";

        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("이름은 빈 값이나 공백일 수 없다.")
    void isNameNotEmptyOrBlank(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 2자 이상, 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름은 공백을 포함할 수 없다.")
    void isNameNotContainBlank() {
        String name = "po bi";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백이 포함될 수 없습니다.");
    }
}
