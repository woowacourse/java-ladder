import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        int maximumHeight = 5;
        Ladder ladder = new Ladder(maximumHeight, List.of());
        assertThat(ladder.height()).isEqualTo(maximumHeight);
    }

    @DisplayName("최대 사다리의 높이는 양수가 되어야 한다.")
    @Test
    void ladderHeightIsPositive() {
        int maximumHeight = -1;
        assertThatThrownBy(() -> new Ladder(maximumHeight, List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 사다리의 높이는 양수가 되어야 합니다");
    }

    @DisplayName("사다리의 행 내부의 라인은 랜덤하게 결정한다.")
    @RepeatedTest(100)
    void makeLines() {
        Ladder ladder = new Ladder(1, List.of(new LadderRow(5)));
        ladder.makeLine();
        assertThat(ladder.getLines().get(0).size()).isEqualTo(4);
    }

}
