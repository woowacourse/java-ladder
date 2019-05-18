package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    public void match() {
        List<Integer> ladderResult = new ArrayList<>();
        List<String> items = new ArrayList<>();
        List<String> matchResult = new ArrayList<>();

        ladderResult.add(0);
        items.add("pobi");
        matchResult.add("pobi");

        LadderResult ladderResult1 = new LadderResult(ladderResult);

        assertThat(ladderResult1.match(items)).isEqualTo(matchResult);
    }
}
