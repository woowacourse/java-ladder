package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class LadderTest {
    @Test
    @DisplayName("사다리 높이가 2 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        int input = 1;
        Assertions.assertThatThrownBy(() -> new Ladder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 높이가 2 이상이면 통과하는 테스트")
    void validHeightTest() {
        int input = 2;
        assertThatCode(() -> new Ladder(input)).doesNotThrowAnyException();
    }
}