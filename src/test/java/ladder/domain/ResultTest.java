package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void resultConstructTest() {
        Result result = new Result("100");

        assertThat(result.value()).isEqualTo("100");
    }
}
