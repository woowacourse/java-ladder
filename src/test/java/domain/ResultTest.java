package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    @DisplayName("결과는 1자 이상 5자 이하이다.")
    void generateValidResult() {
        Result result = new Result("1000");
        assertThat(result.getValue()).isEqualTo("1000");
    }
}
