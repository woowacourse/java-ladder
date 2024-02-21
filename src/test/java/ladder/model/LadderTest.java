package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("지정된 높이와 폭의 사다리를 생성할 수 있다.")
    void createLadderTest() {
        LadderSize size = new LadderSize(7, 5);
        Ladder ladder = Ladder.of(size);
        
        assertThat(ladder.getSize()).isEqualTo(new LadderSize(7, 5));
    }
}
