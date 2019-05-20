package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @Test
    void 생성자_null입력() {
        assertThrows(IllegalArgumentException.class, () -> new Reward(null));
    }

    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> new Reward(""));
    }

    @Test
    void 생성자_글자수_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Reward("123456"));
    }
}