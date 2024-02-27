package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @DisplayName("실행 결과 목록에서 실행 결과들을 조회할 수 있다.")
    @Test
    void create() {
        String value = "1";
        Results results = new Results(List.of(value));

        List<String> values = results.getResults().stream()
                .map(Result::getValue)
                .toList();

        assertThat(values).containsExactly(value);
    }
}
