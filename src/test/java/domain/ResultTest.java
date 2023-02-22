package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {
    @Test
    @DisplayName("결과는 1자 이상 5자 이하이다.")
    void generateValidResult() {
        Result result = Result.from("1000");
        assertThat(result.getValue()).isEqualTo("1000");
    }
}
