package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    @DisplayName("전체 실행 결과를 반환한다.")
    void getAllResults() {
        Results results = new Results(Arrays.asList("꽝", "5000", "꽝", "3000"));
        List<String> allResults = results.getAll();

        assertThat(allResults).containsExactly("꽝", "5000", "꽝", "3000");
    }
}
