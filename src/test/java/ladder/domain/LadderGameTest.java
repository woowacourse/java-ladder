package ladder.domain;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    private Names players;
    private Names rewards;
    private Rows rows;

    @BeforeEach
    void init() {
        players = new PlayerNames("피피,세바스찬,김박박,엘리자베스");
        rewards = new RewardNames("꽝,5000,꽝,3000", 4);
        rows = new Rows(5, 4);
    }

    @Test
    void True_사다리_결과() {
        rows.generateLegsOfLines(new MockStepGenerator(Step.CONNECTED));
        LadderGame ladderGame = new LadderGame(players, rows, rewards);
        /**
         * 피0  세1  김2   엘3
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * |----|    |----|
         * 꽝 5000   꽝   3000
         */
        ladderGame.makeResultMap();
        Assertions.assertThat(ladderGame.getReward(players.getElement(0)))
            .isEqualTo(rewards.getElement(1));
        Assertions.assertThat(ladderGame.getReward(players.getElement(1)))
            .isEqualTo(rewards.getElement(0));
        Assertions.assertThat(ladderGame.getReward(players.getElement(2)))
            .isEqualTo(rewards.getElement(3));
        Assertions.assertThat(ladderGame.getReward(players.getElement(3)))
            .isEqualTo(rewards.getElement(2));
    }

    @Test
    void False_사다리_결과() {
        rows.generateLegsOfLines(new MockStepGenerator(Step.BLANK));
        LadderGame ladderGame = new LadderGame(players, rows, rewards);

        ladderGame.makeResultMap();
        Assertions.assertThat(ladderGame.getReward(players.getElement(0)))
            .isEqualTo(rewards.getElement(0));
        Assertions.assertThat(ladderGame.getReward(players.getElement(1)))
            .isEqualTo(rewards.getElement(1));
        Assertions.assertThat(ladderGame.getReward(players.getElement(2)))
            .isEqualTo(rewards.getElement(2));
        Assertions.assertThat(ladderGame.getReward(players.getElement(3)))
            .isEqualTo(rewards.getElement(3));
    }
}

