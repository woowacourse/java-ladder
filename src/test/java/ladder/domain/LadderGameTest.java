package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    GamePlayers gamePlayers = new GamePlayers(new PlayerGenerator("pobi,crong").generate());
    PlayerRewards playerRewards = new PlayerRewardsGenerator("1,2,3").generate();

    @Test
    void 사람수와_결과의수가_다를때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(4, gamePlayers, playerRewards);
        });
    }
}