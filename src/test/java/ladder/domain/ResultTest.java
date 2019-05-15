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
        List<Player> resultPlayers = Arrays.asList(new Player("pobi", 2),
                new Player("crong", 1),
                new Player("honux", 0));

        Map<Player, String> result = new HashMap<>();
        result.put(new Player("honux", 0), "꽝");
        result.put(new Player("crong", 1), "2000");
        result.put(new Player("pobi", 2), "3000");

        List<String> rewards = Arrays.asList("꽝", "2000", "3000");

        assertThat((new Result(resultPlayers, rewards)).getResult()).isEqualTo(result);
    }
}
