package domain;

import domain.result.Result;
import domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @DisplayName("실행 결과의 수는 사용자의 수와 동일하다.")
    @Test
    void create() {
        String value = "1";
        int playerCount = 1;
        Results results = new Results(List.of(value), playerCount);

        List<String> values = results.getResults().stream()
                .map(Result::getValue)
                .toList();

        assertThat(values).containsExactly(value);
    }
}
