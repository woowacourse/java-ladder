package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("실행 결과")
public class ResultItemTest {
    @Test
    @DisplayName("실행 결과 객체를 생성한다.")
    void createExecutionResult() {
        assertThatCode(() -> {
            new ResultItem("result1");
        })
        .doesNotThrowAnyException();
    }
}
