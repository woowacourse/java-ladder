package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.error.ErrorMessage;

class NameTest {

    @ParameterizedTest(name = "이름은 1글자 이상 5글자 이하여야 한다.")
    @ValueSource(strings = {"쥬니", "리  오", "123", " 킹왕짱 ", "#$%@!"})
    void createNameSuccessTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("이름은 5글자 이하여야 한다.")
    void createNameFailByLengthTest() {
        assertThatThrownBy(() -> new Name("ABCDEF")).
            isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름은 빈 문자열일 수 없다.")
    void createNameFailByEmptyInputTest() {
        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름은 null일 수 없다.")
    void createNameFailByNullTest() {
        assertThatThrownBy(() -> new Name(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NAME_IS_NULL.getMessage());
    }

    @Test
    @DisplayName("이름에 쉼표(,)가 포함될 수 없다.")
    void createNameFailByIncludingCommaTest() {
        assertThatThrownBy(() -> new Name("yo,me"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
    }
}
