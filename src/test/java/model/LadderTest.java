package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        Height height = new Height(5);
        Ladder ladder = new Ladder(height, () -> true, 2);
        assertThat(ladder.getHeight()).isEqualTo(height.value());
    }

    @DisplayName("사다리의 열의 크기는 참가자의 수보다 1 작다")
    @Test
    void ladderColumnOneLessThanParticipantSize() {
        Height height = new Height(5);
        Ladder ladder = new Ladder(height, () -> true, 2);
        assertThat(ladder.getLadderRowSize()).isEqualTo(1);
    }

    @DisplayName("참가자의 전체 이동 결과를 알려준다.")
    @Test
    void moveAll() {
        Ladder ladder = new Ladder(List.of(
                new LadderRow(() -> true, 4),
                new LadderRow(() -> true, 4)));

        assertAll(() -> Assertions.assertThat(ladder.findLinkedPosition(new Position(0))).isEqualTo(new Position(0)),
                () -> Assertions.assertThat(ladder.findLinkedPosition(new Position(1))).isEqualTo(new Position(1)),
                () -> Assertions.assertThat(ladder.findLinkedPosition(new Position(2))).isEqualTo(new Position(2)),
                () -> Assertions.assertThat(ladder.findLinkedPosition(new Position(3))).isEqualTo(new Position(3)),
                () -> Assertions.assertThat(ladder.findLinkedPosition(new Position(4))).isEqualTo(new Position(4)));
    }

        /*
     0     1     2      3      4
     |-----|     |------|      |
     |-----|     |------|      |
     0     1     2      3      4
 */

}
