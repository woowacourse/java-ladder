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
        List<Player> resultPlayers = Arrays.asList(new Player("pobi", 2, 3),
                new Player("crong", 1, 3),
                new Player("honux", 0, 3));

        Map<String, String> result = new HashMap<>();
        result.put("honux", "꽝");
        result.put("crong", "2000");
        result.put("pobi", "3000");

        List<String> rewards = Arrays.asList("꽝", "2000", "3000");

        assertThat((new Result(resultPlayers, rewards)).getResult()).isEqualTo(result);
    }
}
