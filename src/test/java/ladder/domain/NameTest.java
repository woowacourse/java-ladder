package ladder.domain;

import ladder.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest(name = "이름은 1글자 이상 5글자 이하여야 한다.")
    @ValueSource(strings = {"쥬니", "리  오", "123", " 킹왕짱 ", "#$%@!"})
    void createNameSuccessTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("이름은 5글자 이하여야 한다.")
    void createNameFailByLengthTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Name("ABCDEF"));
        assertEquals(ErrorMessage.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("이름은 빈 문자열일 수 없다.")
    void createNameFailByEmptyInputTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Name(""));
        assertEquals(ErrorMessage.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("이름은 null일 수 없다.")
    void createNameFailByNullTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Name(null));
        assertEquals(ErrorMessage.NAME_IS_NULL.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("이름에 쉼표(,)가 포함될 수 없다.")
    void createNameFailByIncludingCommaTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Name("yo,me"));
        assertEquals(ErrorMessage.INVALID_NAME_FORMAT.getMessage(), exception.getMessage());
    }
}
