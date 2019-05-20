package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RewardFactoryTest {

    @Test
    void createAll_플레이어수랑_다른_리워드수() {
        List<Player> players = Arrays.asList(new Player("hi"));
        List<String> rewardNames = Arrays.asList("꽝", "꽈앙");

        assertThrows(IllegalArgumentException.class, () -> RewardFactory.createAll(rewardNames, players));
    }
}