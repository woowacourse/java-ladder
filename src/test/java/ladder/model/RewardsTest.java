package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class RewardsTest {

    @Test
    @DisplayName("플레이어 수와 실행 결과 수가 일치하지 않는 경우 예외처리 테스트")
    void invalidResultCountTest(){
        List<Reward> rewards = new ArrayList<>(List.of(new Reward("꽝"), new Reward("꽝"), new Reward("3000"), new Reward("5000")));
        Assertions.assertThatThrownBy(() -> new Rewards(rewards, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어 수와 실행 결과 수가 일치하면 통과 테스트")
    void validResultCountTest(){
        List<Reward> rewards = new ArrayList<>(List.of(new Reward("꽝"), new Reward("꽝"), new Reward("3000"), new Reward("5000")));
        assertThatCode(() -> new Rewards(rewards, 4)).doesNotThrowAnyException();
    }

}
