package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardTest {
    @Test
    void nameLengthOverTest() {
        assertThrows(RuntimeException.class, () -> new Reward("123456"));
    }

    @Test
    void nameLengthZeroTest() {
        assertThrows(RuntimeException.class, () -> new Reward(""));
    }

    @Test
    void nameNullTest() {
        assertThrows(RuntimeException.class, () -> new Reward(null));
    }
}
