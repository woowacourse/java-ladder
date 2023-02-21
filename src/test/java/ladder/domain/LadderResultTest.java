package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "꽝", "3000"})
    @DisplayName("실행 결과를 받아서 LadderResult를 생성한다.")
    void generateTest(String result) {
        Assertions.assertDoesNotThrow(() -> new LadderResult(result));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "#", "a", "a1", "1.1"})
    @DisplayName("\"꽝\" 이외의 실행 결과가 정수가 아니면 예외를 던진다.")
    void validateRunResultNumericExceptNoLuckTest(String runResult) {
        assertThatThrownBy(() -> new LadderResult(runResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] \"꽝\" 이외의 실행 결과는 정수여야합니다.");
    }

    @Test
    @DisplayName("실행 결과가 \"꽝\"이면 정수가 아니어도 예외가 발생하지 않는다.")
    void validatePassWhenNoLuckTest() {
        String runResult = "꽝";
        Assertions.assertDoesNotThrow(() -> new LadderResult(runResult));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, -1, 10001, 10000"})
    @DisplayName("실행 결과가 정수일 때 1 이상 10000 이하가 아니면 예외를 던진다.")
    void validateRunResultRangeTest(String runResult) {
        assertThatThrownBy(() -> new LadderResult(runResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] \"꽝\" 이외의 실행 결과는 1 이상 10000 이하의 정수여야합니다.");
    }
}
