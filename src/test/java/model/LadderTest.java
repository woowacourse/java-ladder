package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("사다리는 사다리 높이만큼의 라인을 가진다")
    @Test
    void testSizeOfLadderLines() {
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.create(ladderHeight, 3, (count) -> List.of(true, false, true));
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }
}
