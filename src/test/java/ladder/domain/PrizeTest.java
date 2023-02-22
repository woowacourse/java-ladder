package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    public void 이름이_공백으로만_이루어져있으면_예외던지기() {
        assertThatThrownBy(() -> new Prize("    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품명은 공백으로만 이루어질 수 없습니다.");
    }
}
