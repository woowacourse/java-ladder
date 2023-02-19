package ladder.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Result;
import ladder.domain.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void ofResults_success() {
        // given
        Results results = new Results(createResults(), 4);

        // when
        ResultsResponse resultsResponse = ResultsResponse.ofResults(results);

        // then
        assertThat(resultsResponse.getResults())
                .isEqualTo("꽝     5000  꽝     3000 ");
    }

    private static List<Result> createResults() {
        return List.of(
                new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("3000"));
    }
}
