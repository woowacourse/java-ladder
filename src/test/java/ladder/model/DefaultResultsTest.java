package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultResultsTest {

    DefaultResults results;

    @BeforeEach
    void setUp() {
        results = new DefaultResults(Arrays.asList(new Result("5000"), new Result("3000"), new Result("꽝")));
    }

    @Test
    void 생성() {
        assertThat(results)
                .isEqualTo(new DefaultResults(Arrays.asList(new Result("5000"), new Result("3000"), new Result("꽝"))));
    }

    @Test
    void 첫번째에_5000의_결과값이_있는지_테스트() {
        assertThat(results.getResult(0)).isEqualTo(new Result("5000"));
    }
}
