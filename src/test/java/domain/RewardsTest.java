package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RewardsTest {
    @Test
    @DisplayName("보상 목록을 포함한 일급 컬렉션을 만든다.")
    public void createRewards() {
        List<String> value = List.of("꽝", "5000", "꽝", "3000");

        assertThatCode(() -> Rewards.from(value, value.size()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보상 목록이 플레이어 수와 다를시 예외를 발생한다.")
    public void throwExceptionWhenRewardsNotEqualSize() {
        List<String> value = List.of("꽝", "5000", "꽝");
        int playerSize = 4;

        assertThrows(IllegalArgumentException.class, () -> Rewards.from(value, playerSize));
    }

}
