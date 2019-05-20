package ladder.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardExceptionTest {
    @Test
    void reward_사이즈_초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            RewardException.reward("1,2,3", 2);
        });
    }

    @Test
    void reward_사이즈_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            RewardException.reward("1,2,3", 2);
        });
    }
}
