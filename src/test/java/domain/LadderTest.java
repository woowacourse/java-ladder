package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리의 높이가 다리 열 개수와 같음")
    void validateRowCount() {
        Height height = new Height(5);
        Width width = new Width(5);
        Ladder ladder = new Ladder(height, width, new BridgesRandomGenerator());
        Assertions.assertThat(ladder.getRows().size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("사다리를 Wrapper 타입을 이용해 생성할 때 예외가 발생하지 않음")
    void testConstructWithWrapper() {
        Height height = new Height(5);
        Width width = new Width(5);

        Assertions.assertThatCode(() -> new Ladder(height, width, new BridgesRandomGenerator()))
                .doesNotThrowAnyException();

    }
}