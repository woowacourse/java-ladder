package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @Test
    @DisplayName("Results는 Result를 담은 List를 통해 생성할 수 있다.")
    void resultsTest() {
        Result result1 = new Result("결과1");
        Result result2 = new Result("결과2");
        Results results = new Results(List.of(result1, result2));

        Assertions.assertThat(results.getResults()).containsExactly(result1, result2);
    }
}
