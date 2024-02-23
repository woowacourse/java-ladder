package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 전체 폭 검증")
    void validateRowCount() {
        Ladder ladder = new Ladder(5, 5, new BridgeRandomGenerator());
        Assertions.assertThat(ladder.getRows().size())
                .isEqualTo(5);
    }
}
