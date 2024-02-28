package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
