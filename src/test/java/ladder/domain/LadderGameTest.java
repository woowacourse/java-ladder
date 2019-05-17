package ladder.domain;

import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    GamePlayers gamePlayers;
    PlayerRewards playerRewards;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        gamePlayers = new GamePlayers(new PlayerGenerator("pobi,crong").generate());
        playerRewards = new PlayerRewardsGenerator("꽝, 5000").generate();
    }

    @Test
    void 사람수와_결과의수가_다를때() {
        playerRewards = new PlayerRewardsGenerator("1,2,3").generate();
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(4, gamePlayers, playerRewards);
        });
    }

    @Test
    void 사다리_게임_진행() {
        LadderGame ladderGame = new LadderGame(2, gamePlayers, playerRewards);

//        String reward = ladderGame.findPlayerReward("pobi");

//        LadderGame ladderGame = new LadderGame()
    }
}