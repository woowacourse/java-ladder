package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        Height height = new Height(5);
//        Ladder ladder = new Ladder(height, () -> List.of(true, false, true));
//        assertThat(ladder.getHeight()).isEqualTo(height.value());
    }
}
