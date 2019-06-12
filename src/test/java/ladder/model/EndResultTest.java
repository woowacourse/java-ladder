package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EndResultTest {
    Result result1;
    Result result2;
    List<Result> results;
    EndResult endResults;

    @BeforeEach
    void setUp() {
        result1 = new Result("1", "a");
        result2 = new Result("2", "b");
        results = Arrays.asList(result1, result2);
        endResults = new EndResult(results);
    }

    @Test
    void 확인_1명() {
        assertThat(endResults.getMemberResult("a"))
                .isEqualTo(result1);
    }

    @Test
    void 확인_모두() {
        assertThat(endResults.getAllResult())
                .isEqualTo(results);
    }
}
