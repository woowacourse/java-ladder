package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RewardsTest {

    @Test
    @DisplayName("실행결과 개수와 플레이어 개수가 일치하지 않으면 예외처리 테스트")
    void rewardsCountTest() {
        List<String> input = new ArrayList<>(List.of("꽝,꽝,당첨,당첨,꽝".split(",")));
        List<Reward> rewards = input.stream().map(Reward::new).collect(Collectors.toList());

        assertThatThrownBy(() -> Rewards.of(rewards, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
