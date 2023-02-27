package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "abcde"})
    @DisplayName("결과를 생성한다")
    void shouldNotThrowExceptionWhenCreateResult(String input) {
        assertDoesNotThrow(() -> new Result(input));
    }

    @Test
    @DisplayName("내용을 반환한다")
    void shouldReturnContentWhenRequest() {
        Result result = new Result("테스트");
        assertThat(result.content()).isEqualTo("테스트");
    }
}