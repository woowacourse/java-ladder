package ladder.domain.Reward;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardTest {
    @Test
    public void 이름_글자_제한() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reward("123456");
        });
    }

}