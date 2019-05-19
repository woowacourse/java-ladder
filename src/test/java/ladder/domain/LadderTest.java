package ladder.domain;

import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 높이_유효성_테스트() {
        int height = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(height, () -> {
                return null;
            });
        });
    }

    @Test
    public void playTest() {
        GamePlayers gamePlayers = new GamePlayers(new PlayerGenerator("pobi,crong,honux").generate());
        PlayerRewards playerRewards = new PlayerRewardsGenerator("꽝, 5000, 3000").generate();

        List<Direction> directions = Arrays.asList(
                Direction.first(true),
                Direction.of(true, false),
                Direction.of(false, false));
        Ladder ladder = new Ladder(3, () -> directions);

        Map<String, String> result = ladder.play(gamePlayers, playerRewards);

        assertThat(result.get("honux")).isEqualTo("3000");
        assertThat(result.get("pobi")).isEqualTo("5000");
        assertThat(result.get("crong")).isEqualTo("꽝");
    }
}
