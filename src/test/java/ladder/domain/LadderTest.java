package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 사다리결과테스트() {
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(true, false)),
                new Line(Arrays.asList(false, true)),
                new Line(Arrays.asList(true, false)));

        List<Player> initialPlayers = Arrays.asList(new Player("pobi", 0, 3),
                new Player("crong", 1, 3),
                new Player("honux", 2, 3));

        List<Player> resultPlayers = Arrays.asList(new Player("pobi", 2, 3),
                new Player("crong", 1, 3),
                new Player("honux", 0, 3));

        List<Player> result = Ladder.goDown(lines, initialPlayers);

        assertThat(result).isEqualTo(resultPlayers);
    }
}
