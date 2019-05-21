package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    public void match() {
        List<Integer> ladderResult = Arrays.asList(1, 0);
        Items items = new Items(Arrays.asList("100", "꽝"), 2);

        List<String> matchResult = Arrays.asList("꽝", "100");

        assertThat(new LadderResult(ladderResult).match(items)).isEqualTo(matchResult);
    }
}
