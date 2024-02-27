package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RewardsTest {
    @Test
    @DisplayName("보상 목록을 포함한 일급 컬렉션을 만든다.")
    public void createRewards() {
        List<String> value = List.of("꽝", "5000", "꽝", "3000");

        assertThatCode(() -> Rewards.from(value))
                .doesNotThrowAnyException();
    }

}
