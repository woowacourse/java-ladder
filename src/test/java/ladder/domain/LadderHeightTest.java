package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {
    @DisplayName("사다리 높이가 2보다 작으면 예외를 던진다")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void createLadderHeightByInvalidRange(final int ladderHeight) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(ladderHeight))
                .withMessage("사다리 크기는 2 이상이어야 합니다.");
    }
}
