package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardTest {
    @Test
    void null_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reward(null);
        });
    }

    @Test
    void 공백_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reward("");
        });
    }

    @Test
    void 다섯자_초과_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reward("abcdef");
        });
    }
}
