package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("라인 실행 결과를 계산한다.")
    @Test
    void calculateNext() {
        // given
        List<ResultItem> resultItems = List.of(
                new ResultItem("꽝"),
                new ResultItem("5000"),
                new ResultItem("꽝"),
                new ResultItem("3000"));
        Result result = new Result(resultItems);

        Line line = new Line(5, (size) -> {
                return List.of(Point.USED, Point.UNUSED, Point.USED, Point.UNUSED);
        });

        // when
        result.calculateNext(line);

        // then
        assertThat(result.getResultItems()).containsExactly(
                new ResultItem("5000"),
                new ResultItem("꽝"),
                new ResultItem("3000"),
                new ResultItem("꽝"));
    }
}
