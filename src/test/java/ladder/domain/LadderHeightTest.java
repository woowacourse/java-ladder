package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {
    @DisplayName("2 ~ 10에 포함되지 않는 값이 입력되면 예외를 던진다.")
    @ValueSource(ints = {-1, 0, 11})
    @ParameterizedTest
    void createLadderHeightByInvalidRange(final int ladderHeight) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(ladderHeight))
                .withMessage("사다리 크기는 2 ~ 10 범위만 가능합니다.");
    }
}
