package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RewardTest {
    @Test
    @DisplayName("Reward는 상품으로 구성된 객체이다.")
    void Test() {
        assertDoesNotThrow(() -> {
            new Reward(List.of("꽝", "1000", "2000", "꽝"));
        });
    }
}
