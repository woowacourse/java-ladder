
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderTest() {
        int maximumHeight = 5;
        Ladder ladder = new Ladder(maximumHeight);
        Assertions.assertThat(ladder.height()).isEqualTo(maximumHeight);
    }
}
