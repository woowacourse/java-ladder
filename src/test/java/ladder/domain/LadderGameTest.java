package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void playTest() {
        List<String> names = Arrays.asList("done", "cony", "pobi");
        List<String> items = Arrays.asList("꽝", "10000", "꽝");
        LadderBuilder ladderBuilder = new LadderBuilder();
        Ladder ladder = ladderBuilder.build(3, 3);

        Map<String, String> result = LadderGame.play(ladder, names, items);
        Map<String, String> result2 = new HashMap<>();

        result2.put("done", "꽝");
        result2.put("cony", "10000");
        result2.put("pobi", "꽝");

        assertThat(result).isEqualTo(result2);
    }
}
