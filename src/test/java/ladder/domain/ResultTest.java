package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 사다리게임결과생성() {
        Map<String, Integer> positions = new HashMap<>();
        positions.put("pobi", 2);
        positions.put("crong", 1);
        positions.put("honux", 0);

        Map<String, String> result = new HashMap<>();
        result.put("honux", "꽝");
        result.put("crong", "2000");
        result.put("pobi", "3000");

        List<String> rewards = Arrays.asList("꽝", "2000", "3000");

        assertThat((new Result(positions, rewards)).getResult()).isEqualTo(result);
    }
}
