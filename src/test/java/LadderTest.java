
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        int maximumHeight = 5;
        Ladder ladder = new Ladder(maximumHeight);
        assertThat(ladder.height()).isEqualTo(maximumHeight);
    }

    @DisplayName("최대 사다리의 높이는 양수가 되어야 한다.")
    @Test
    void ladderHeightIsPositive() {
        int maximumHeight = -1;
        assertThatThrownBy(() -> new Ladder(maximumHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 사다리의 높이는 양수가 되어야 합니다");
    }
}
