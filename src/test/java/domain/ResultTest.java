package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {
    @Test
    @DisplayName("실행 결과는 5글자 이하다.")
    void isResultUnderMaxLengthLimit() {
        String result = "50000";

        assertDoesNotThrow(() -> new Result(result));
    }

    @Test
    @DisplayName("실행 결과가 5글자를 넘으면 예외가 발생한다.")
    void printResult() {
        String result = "500000";

        assertThrows(IllegalArgumentException.class, () -> new Result(result));
    }

    @Test
    @DisplayName("실행 결과는 1글자 이상이다.")
    void isValidResult() {
        String result = "5";

        assertDoesNotThrow(() -> new Result(result));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("실행 결과가 비어있다면 예외가 발생한다.")
    void isResultNotEmpty(final String result) {
        assertThrows(IllegalArgumentException.class, () -> new Result(result));
    }
}
