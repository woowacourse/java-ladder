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

public class GameResultTest {
    GameResult gameResult;
    GamePlayers gamePlayers;
    PlayerRewards playerRewards;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        gamePlayers = new GamePlayers(new PlayerGenerator("pobi,crong,honux").generate());
        PlayerRewards playerRewards = new PlayerRewardsGenerator("꽝, 5000, 3000").generate();
        List<Direction> line1 = Arrays.asList(
                new Direction(false, false),
                new Direction(false, true),
                new Direction(true, false));

        List<Direction> line2 = Arrays.asList(
                new Direction(false, true),
                new Direction(true, false),
                new Direction(false, false));

        List<Line> lines = Arrays.asList(new Line(line1.size(), () -> line1), new Line(line2.size(), () -> line2));
        ladder = new Ladder(lines.size(), gamePlayers.size(), () -> lines);

        gameResult = new GameResult(ladder, gamePlayers, playerRewards);
    }

    @Test
    void 사람수와_상품수가_다름() {
        playerRewards = new PlayerRewardsGenerator("1").generate();
        assertThrows(IllegalArgumentException.class, () -> {
            new GameResult(ladder, gamePlayers, playerRewards);
        });
    }

    @Test
    void 한명_결과() {
        assertThat(new Reward("5000")).isEqualTo(gameResult.get(new Player("pobi")));
        assertThat(new Reward("3000")).isEqualTo(gameResult.get(new Player("crong")));
        assertThat(new Reward("꽝")).isEqualTo(gameResult.get(new Player("honux")));
    }

    @Test
    void 전체_결과() {
        Map<Player, Reward> expected = gameResult.getAllResults();

        assertThat(3).isEqualTo(expected.size());
        assertThat(new Reward("5000")).isEqualTo(expected.get(new Player("pobi")));
        assertThat(new Reward("3000")).isEqualTo(expected.get(new Player("crong")));
        assertThat(new Reward("꽝")).isEqualTo(expected.get(new Player("honux")));
    }
}
