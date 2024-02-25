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
    @DisplayName("사람 이름은 5글자를 넘을 수 없다.")
    void isNameOverMaxLengthLimit() {
        String invalidName = "pobipo";
        String validName = "pobi";

        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
        assertDoesNotThrow(() -> new Name(validName));
    }

    @Test
    @DisplayName("이름은 2글자 이상이어야 한다.")
    void isValidName() {
        String invalidName = "p";
        String validName = "po";

        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
        assertDoesNotThrow(() -> new Name(validName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("이름은 빈 값이나 공백일 수 없다.")
    void isNameNotEmptyOrBlank(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 2자 이상, 5자 이하여야 합니다.");
    }
}
