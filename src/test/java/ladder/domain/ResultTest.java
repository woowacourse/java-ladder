package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 출력() {
        Result result = new Result(Arrays.asList("꽝", "5000"));
        assertThat(result.toString()).isEqualTo("     꽝  5000");
    }
}
