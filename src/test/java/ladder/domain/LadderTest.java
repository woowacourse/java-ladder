package ladder.domain;

import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    GamePlayers gamePlayers;
    PlayerRewards playerRewards;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        gamePlayers = new GamePlayers(new PlayerGenerator("pobi,crong,honux").generate());
        playerRewards = new PlayerRewardsGenerator("꽝, 5000, 3000").generate();
        List<Direction> directions = Arrays.asList(
                Direction.first(true),
                Direction.of(true, false),
                Direction.of(false, false));
        ladder = new Ladder(3, () -> directions);
    }

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
        Map<String, String> result = ladder.play(gamePlayers, playerRewards);

        assertThat(result.get("honux")).isEqualTo("3000");
        assertThat(result.get("pobi")).isEqualTo("5000");
        assertThat(result.get("crong")).isEqualTo("꽝");
    }

    @Test
    public void 플레이어와_결과_size_다름_검사() {
        playerRewards = new PlayerRewardsGenerator("꽝, 5000, 3000, 5000").generate();
        assertThrows(IllegalArgumentException.class, ()->{
            Map<String, String> result = ladder.play(gamePlayers, playerRewards);
        });
    }
}
