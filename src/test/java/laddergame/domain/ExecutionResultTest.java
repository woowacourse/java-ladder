package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("실행 결과")
public class ExecutionResultTest {
    @Test
    @DisplayName("실행 결과 객체를 생성한다.")
    void createExecutionResult() {
        assertThatCode(() -> {
            new ExecutionResult(List.of("result1", "result2", "result3"));
        })
        .doesNotThrowAnyException();
    }

}
