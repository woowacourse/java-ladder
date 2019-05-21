package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {
    @Test
    void rewardsNotNullTest() {
        Players.NUM_OF_PLAYERS = 3;
        assertThrows(RuntimeException.class, () -> new Rewards(null));
    }

    @Test
    void rewardsLengthOverNumOfPlayersTest() {
        Players.NUM_OF_PLAYERS = 3;
        assertThrows(RuntimeException.class, () -> new Rewards(Arrays.asList(new Reward("pobi"),
                new Reward("crong"), new Reward("honux"), new Reward("papa"))));
    }

    @Test
    void rewardsLengthNotNumOfPlayersTest() {
        Players.NUM_OF_PLAYERS = 3;
        assertThrows(RuntimeException.class, () -> new Rewards(Arrays.asList(new Reward("pobi"),
                new Reward("crong"), new Reward("honux"), new Reward("papa"))));
    }
}
