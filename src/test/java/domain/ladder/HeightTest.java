package domain.ladder;

import domain.ladder.attirbute.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    @DisplayName("입력된 숫자 문자열을 통해 Height를 생성한다.")
    void createHeight() {

        String value = "5";

        Height height = new Height(value);

        assertEquals(height.getValue(), Integer.parseInt(value));
    }

    @Test
    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    void throwExceptionWhenInputStringIsNotNumber() {

        String value = "five";

        assertThrows(IllegalArgumentException.class, () -> new Height(value));
    }

    @ParameterizedTest
    @DisplayName("1보다 작은 값이면 예외를 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void throwExceptionWhenInputNumberIsSmallerThanOne(String value) {
        assertThrows(IllegalArgumentException.class, () -> new Height(value));
    }

}
