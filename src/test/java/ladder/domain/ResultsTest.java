package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @DisplayName("위치를 입력하여 그 위치의 결과를 반환한다.")
    @Test
    void getResultTest() {
        Results results = new Results(List.of(new Result("꽝"), new Result("5000")));

        assertAll(
                () -> assertThat(results.getResult(new Location(0))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(new Location(1))).isEqualTo(new Result("5000"))
        );
    }

    @DisplayName("모든 결과를 반환한다.")
    @Test
    void getAllResultsTest() {
        Results results = new Results(List.of(new Result("꽝"), new Result("5000")));
        List<Result> allResults = results.getResults();

        assertAll(
                () -> assertThat(allResults.get(0)).isEqualTo(new Result("꽝")),
                () -> assertThat(allResults.get(1)).isEqualTo(new Result("5000"))
        );
    }
}
