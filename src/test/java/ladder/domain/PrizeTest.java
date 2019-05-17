package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @Test
    void 상품이_없을_경우() {
        assertThatThrownBy(() -> new Prize(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품이_빈값일_경우() {
        assertThatThrownBy(() -> new Prize("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품이_5글자_초과인_경우() {
        assertThatThrownBy(() -> new Prize("prizes")).isInstanceOf(IllegalArgumentException.class);
    }
}
