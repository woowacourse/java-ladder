package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("실행 결과")
public class ExecutionResultTest {
    @Test
    @DisplayName("실행 결과 객체를 생성한다.")
    void createExecutionResult() {
        assertThatCode(() -> {
            new ExecutionResult(List.of("result1", "result2", "result3"), 3);
        })
        .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("실행 결과가 플레이어 수만큼 존재하지 않으면 오류가 발생한다.")
    void findExecutionResultCountIsPlayersCount() {
        final int playersCount = 4;
        assertThrows(IllegalArgumentException.class,
                () -> new ExecutionResult(List.of("result1", "result2", "result3"), playersCount));
    }
}
