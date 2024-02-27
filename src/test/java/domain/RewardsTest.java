package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    @DisplayName("보상들 객체를 정상적으로 생성합니다.")
    @Test
    void createRewards() {
        assertThatCode(() -> new Rewards(List.of(new Reward("0"))))
                .doesNotThrowAnyException();
    }
}
