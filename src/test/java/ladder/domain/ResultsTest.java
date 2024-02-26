package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @DisplayName("실행 결과를 입력하여 Results를 생성한다.")
    @Test
    void resultsTest() {
        assertThatCode(() -> new Results(List.of("꽝", "5000", "꽝", "3000"), 4))
                .doesNotThrowAnyException();
    }

    @DisplayName("위치를 입력하여 그 위치의 결과를 반환한다.")
    @Test
    void getResultByLocation() {
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), 4);

        assertThat(results.getResultValue(1)).isEqualTo("5000");
    }
}
