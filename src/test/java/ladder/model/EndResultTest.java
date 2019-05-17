package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EndResultTest {
    EndResult endResults;

    @BeforeEach
    void setUp() {
        List<Result> results = Arrays.asList(new Result( "5000", "pobi"), new Result("꽝", "crong"));
        endResults = new EndResult(results);
    }

    @Test
    void pobi_결과_확인() {
        assertThat(endResults.getMemberResult("pobi")).isEqualTo(new Result("5000", "pobi"));
    }

    @Test
    void all_결과_확인() {
        assertThat(endResults.getAllResult())
                .isEqualTo(Arrays.asList(new Result( "5000", "pobi"), new Result("꽝", "crong")));
    }
}
