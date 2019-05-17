package ladder.domain;

import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    GamePlayers gamePlayers;
    PlayerRewards playerRewards;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        gamePlayers = new GamePlayers(new PlayerGenerator("pobi, crong, honux").generate());
        playerRewards = new PlayerRewardsGenerator("꽝, 5000, 3000").generate();
    }

    @Test
    void 사람수와_결과의수가_다를때() {
        playerRewards = new PlayerRewardsGenerator("1,2,3,4").generate();
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(4, gamePlayers, playerRewards);
        });
    }

    @Test
    void 사다리_게임_진행() {
        List<Boolean> line1 = Arrays.asList(false, true);
        List<Boolean> line2 = Arrays.asList(true, false);

        List<Line> lines = Arrays.asList(new Line(line1.size(), () -> line1), new Line(line2.size(), () -> line2));

        LadderGame ladderGame = new LadderGame(2, gamePlayers, playerRewards, () -> lines);

        String actualReward = ladderGame.findPlayerReward("pobi");
        assertThat(playerRewards.getReward(1)).isEqualTo(actualReward);
    }
}