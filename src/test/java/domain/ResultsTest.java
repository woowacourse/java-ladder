package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @Test
    @DisplayName("Results 안에 있는 Result의 개수는 사람 수와 같아야 한다.")
    void should_resultCountEqualToUserCount_when_results() {
        Result result1 = new Result("결과1");
        Result result2 = new Result("결과2");

        Results results = new Results(List.of(result1, result2), 2);

        Assertions.assertThat(results.getResults()).containsExactly(result1, result2);
    }

    @Test
    @DisplayName("Results 안에 있는 Result의 개수가 사람 수와 같지 않다면 예외를 던진다.")
    void should_throwException_when_resultCountNotEqualToUserCount() {
        Result result1 = new Result("결과1");
        Result result2 = new Result("결과2");

        Assertions.assertThatThrownBy(() -> new Results(List.of(result1, result2), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
