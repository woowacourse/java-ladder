package ladder.domain;

import ladder.error.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {

    @ParameterizedTest(name = "이름은 1글자 이상 5글자 이하여야 한다.")
    @ValueSource(strings = {"쥬니", "리  오", "123", " 킹왕짱 ", "#$%@!"})
    void createNameSuccessTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("이름은 5글자 이하여야 한다.")
    @Test
    void createNameFailByLengthTest() {
        assertThatThrownBy(() -> new Name("ABCDEF"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @DisplayName("이름은 빈 문자열일 수 없다.")
    @Test
    void createNameFailByEmptyInputTest() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @DisplayName("이름은 null일 수 없다.")
    @Test
    void createNameFailByNullTest() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(ErrorMessage.NAME_IS_NULL.getMessage());
    }

    @DisplayName("이름에 쉼표(,)가 포함될 수 없다.")
    @Test
    void createNameFailByIncludingCommaTest() {
        assertThatThrownBy(() -> new Name("yo,me"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
    }

    @DisplayName("이름은 'all'이 될 수 없다.")
    @Test
    void createNameFailByUnavailableName() {
        assertThatThrownBy(() -> new Name("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNAVAILABLE_NAME.getMessage());
    }
}
