package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionResultTest {

    private static ExecutionResult executionResult;

    @BeforeEach
    void createExecutionResult() {
        People people = new People(List.of("pobi", "honux", "crong", "jk"));
        executionResult = new ExecutionResult(people);
    }

    @DisplayName("특정 참여자의 결과 항목을 저장한다.")
    @Test
    void put() {
        // when
        executionResult.put(new Name("pobi"), new ResultItem("꽝"));

        // then
        assertThat(executionResult.get(new Name("pobi"))).isEqualTo(new ResultItem("꽝"));
    }

    @DisplayName("특정 참여자의 결과 항목을 조회한다.")
    @Test
    void get() {
        // given
        executionResult.put(new Name("pobi"), new ResultItem("꽝"));

        // when
        ResultItem expected = executionResult.get(new Name("pobi"));

        // then
        assertThat(expected).isEqualTo(new ResultItem("꽝"));
    }
}
