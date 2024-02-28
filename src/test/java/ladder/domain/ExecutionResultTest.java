package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("모든 참여자의 결과 항목을 조회한다.")
    @Test
    void getAll() {
        // given
        executionResult.put(new Name("pobi"), new ResultItem("꽝"));
        executionResult.put(new Name("honux"), new ResultItem("3000"));
        executionResult.put(new Name("crong"), new ResultItem("꽝"));
        executionResult.put(new Name("jk"), new ResultItem("5000"));

        // when
        List<ResultItem> expected = executionResult.getAll();

        // then
        assertThat(expected).isEqualTo(List.of(
                new ResultItem("꽝"),
                new ResultItem("3000"),
                new ResultItem("꽝"),
                new ResultItem("5000")
        ));
    }

    @DisplayName("null 값이 있는지 확인한다.")
    @Test
    void hasNullValue() {
        // given
        executionResult.put(new Name("pobi"), new ResultItem("꽝"));
        executionResult.put(new Name("honux"), new ResultItem("3000"));
        executionResult.put(new Name("crong"), new ResultItem("꽝"));

        // when
        boolean expected = executionResult.hasNullValue();

        // then
        assertThat(expected).isTrue();
    }

    @DisplayName("null 값이 없는지 확인한다.")
    @Test
    void noNullValue() {
        // given
        executionResult.put(new Name("pobi"), new ResultItem("꽝"));
        executionResult.put(new Name("honux"), new ResultItem("3000"));
        executionResult.put(new Name("crong"), new ResultItem("꽝"));
        executionResult.put(new Name("jk"), new ResultItem("5000"));

        // when
        boolean expected = executionResult.hasNullValue();

        // then
        assertThat(expected).isFalse();
    }

    @DisplayName("특정 참여자의 결과 항목이 null인지 확인한다.")
    @Test
    void hasNullValueForKey() {
        // when
        boolean beforeUpdate = executionResult.hasNullValueForKey(new Name("pobi"));

        executionResult.put(new Name("pobi"), new ResultItem("꽝"));
        boolean afterUpdate = executionResult.hasNullValueForKey(new Name("pobi"));

        // then
        assertAll(
                () -> assertThat(beforeUpdate).isTrue(),
                () -> assertThat(afterUpdate).isFalse()
        );
    }
}
