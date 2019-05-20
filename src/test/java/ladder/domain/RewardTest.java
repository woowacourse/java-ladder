package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardTest {
    @Test
    void 보상_이름_글자수_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Reward("123456"));
    }

    @Test
    void 보상_이름_글자수_미만_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Reward(""));
    }
}
