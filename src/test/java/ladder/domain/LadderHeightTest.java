package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {
    @DisplayName("2 이상의 숫자를 받으면 이상 없이 LadderHeight 인스턴스가 생성된다")
    @Test
    void createLadderHeightWithoutException() {
        assertThat(new LadderHeight(2).value())
                .isEqualTo(2);
    }

    @DisplayName("사다리 높이가 2보다 작으면 예외를 던진다")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void createLadderHeightByInvalidRange(final int ladderHeight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(ladderHeight))
                .withMessage("사다리 크기는 2 이상이어야 합니다.");
    }
}
