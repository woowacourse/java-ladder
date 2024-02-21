package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    @Test
    @DisplayName("유효한 가로줄을 포함하는 사다리를 생성할 수 있다.")
    void createValidLadderTest() {
        assertThatCode(() -> Ladder.of(new LadderSize(10, 10)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("지정된 높이와 폭의 사다리를 생성할 수 있다.")
    void createSpecificSizeOfLadderTest() {
        LadderSize size = new LadderSize(7, 5);
        Ladder ladder = Ladder.of(size);

        assertThat(ladder.getSize()).isEqualTo(new LadderSize(7, 5));
    }
}
