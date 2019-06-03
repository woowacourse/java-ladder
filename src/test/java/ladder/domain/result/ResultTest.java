package ladder.domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 결과_생성() {
        Result result = new Result("꽝");
        assertThat(result).isEqualTo(new Result("꽝"));
    }
}
