package domain;

import domain.game.LadderGame;
import domain.game.Results;
import domain.info.Info;
import domain.info.Names;
import domain.info.Rewards;
import domain.ladder.Height;
import domain.ladder.Ladder;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BooleanGenerator;
import utils.TrueBooleanGenerator;

public class LadderGameTest {
    public BooleanGenerator booleanGenerator;

    @BeforeEach
    void setup() {
        booleanGenerator = new TrueBooleanGenerator();
    }

    @DisplayName("생성된 사다리를 타는 것을 테스트한다.")
    @Test
    void validLinesGameTest() {
        Height height = new Height(1);
        Names names = new Names(Arrays.asList("a", "b", "c", "d"));
        Rewards rewards = new Rewards(Arrays.asList("e", "f", "g", "h"));
        Info info = new Info(names, rewards);
        Ladder ladder = new Ladder(names, height, booleanGenerator);

        LadderGame ladderGame = new LadderGame(info, ladder);
        Results results = ladderGame.play();

        Assertions.assertThat(results.getReward(names.getName(0)))
                .isEqualTo(rewards.getReward(1));
        Assertions.assertThat(results.getReward(names.getName(1)))
                .isEqualTo(rewards.getReward(0));
        Assertions.assertThat(results.getReward(names.getName(2)))
                .isEqualTo(rewards.getReward(3));
        Assertions.assertThat(results.getReward(names.getName(3)))
                .isEqualTo(rewards.getReward(2));
    }
}
