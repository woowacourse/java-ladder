package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {
    @Test
    void 상품이_공백일_경우() {
        assertThatThrownBy(() -> new Reward(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품이_빈값일_경우() {
        assertThatThrownBy(() -> new Reward("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품이_null일_경우() {
        assertThatThrownBy(() -> new Reward(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품이_5글자_초과일_경우() {
        assertThatThrownBy(() -> new Reward("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }
}
