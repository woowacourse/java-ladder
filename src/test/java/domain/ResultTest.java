package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    @DisplayName("실행 결과는 5글자를 넘을 수 없다.")
    void printResult() {
        String invalidResult = "500000";
        String validResult = "50000";

        assertThrows(IllegalArgumentException.class, () -> new Result(invalidResult));
        assertDoesNotThrow(() -> new Result(validResult));
    }
}
