package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    Result result;

    @BeforeEach
    void setUp() {
        result = new Result("5000");
    }

    @Test
    void 생성() {
        assertThat(result).isEqualTo(new Result("5000"));
    }

    @Test
    void 값_5000이_들어있는지_테스트() {
        assertThat(result.getResult()).isEqualTo("5000");
    }
}
