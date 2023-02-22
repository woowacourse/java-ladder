package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "꽝", "3000"})
    @DisplayName("실행 결과를 받아서 LadderResult를 생성한다.")
    void generateTest(String reward) {
        Assertions.assertDoesNotThrow(() -> new Result(new Reward(reward, 0)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    @DisplayName("보상 인덱스로 같은 보상인지 판별한다.")
    void isSameRewardTest(int rewardIndex, boolean expected) {
        Result result = new Result(new Reward("꽝", 0));

        assertThat(result.isSameReward(rewardIndex)).isEqualTo(expected);
    }
}
