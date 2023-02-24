package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    private Names players;
    private Names rewards;
    private Ladder trueLadder;
    private Ladder falseLadder;

    @BeforeEach
    void init() {
        players = new Names("피피,세바스찬,김박박,엘리자베스");
        rewards = new Names("꽝,5000,꽝,3000", 4);
        trueLadder = new Ladder(5, 4, new MockStepGenerator(Step.CONNECTED));
        falseLadder = new Ladder(5, 4, new MockStepGenerator(Step.BLANK));
    }

    @Test
    void True_사다리_결과() {
        LadderGame ladderGame = new LadderGame(players, trueLadder, rewards);
        /**
         * 피0  세1  김2   엘3
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * 꽝 5000   꽝   3000
         */
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(0)))
            .isEqualTo(rewards.findNameByIndex(1).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(1)))
            .isEqualTo(rewards.findNameByIndex(0).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(2)))
            .isEqualTo(rewards.findNameByIndex(3).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(3)))
            .isEqualTo(rewards.findNameByIndex(2).toDto());
    }

    @Test
    void False_사다리_결과() {
        LadderGame ladderGame = new LadderGame(players, falseLadder, rewards);
        /**
         * 피0  세1  김2   엘3
         * |    |    |    |
         * |    |    |    |
         * |    |    |    |
         * |    |    |    |
         * |    |    |    |
         * 꽝 5000   꽝   3000
         */
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(0)))
            .isEqualTo(rewards.findNameByIndex(0).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(1)))
            .isEqualTo(rewards.findNameByIndex(1).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(2)))
            .isEqualTo(rewards.findNameByIndex(2).toDto());
        Assertions.assertThat(ladderGame.getReward(players.findNameByIndex(3)))
            .isEqualTo(rewards.findNameByIndex(3).toDto());
    }
}
