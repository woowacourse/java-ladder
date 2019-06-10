package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    Result result;

    @BeforeEach
    void setUp() {
        result = new Result("꽝", "sloth");
    }

    @Test
    void 우승자_확인() {
        assertThat(result.isWinner("sloth")).isEqualTo(true);
    }

    @Test
    void 우승자_확인_실패() {
        assertThat(result.isWinner("slith")).isEqualTo(false);
    }
}
