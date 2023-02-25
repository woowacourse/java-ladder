package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "abcde"})
    @DisplayName("결과를 생성한다")
    void shouldNotThrowExceptionWhenCreateResult(String input) {
        assertDoesNotThrow(() -> new Result(input));
    }
}