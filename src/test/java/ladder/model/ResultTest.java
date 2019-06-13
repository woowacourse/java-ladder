package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result("1", "abc");
    }

    @Test
    void 우승자_확인() {
        assertThat(result.isEqualsWinnerName("abc")).isEqualTo(true);
    }

    @Test
    void 우승자_확인실패() {
        assertThat(result.isEqualsWinnerName("xyz")).isEqualTo(false);
    }
}
