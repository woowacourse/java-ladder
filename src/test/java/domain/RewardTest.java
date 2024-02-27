package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    @DisplayName("보상 객체를 정상 생성합니다.")
    @Test
    void createReward() {
        Assertions.assertThatCode(() -> new Reward("0"))
                .doesNotThrowAnyException();
    }
}
