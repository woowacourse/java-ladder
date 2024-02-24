package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        int maximumHeight = 5;
        Ladder ladder = new Ladder(maximumHeight);
        ladder.build(3);
        assertThat(ladder.getHeight()).isEqualTo(maximumHeight);
    }

    @DisplayName("한 행에는 연속된 선이 존재하면 안된다.")
    @RepeatedTest(100)
    void makeNotContinuousLineInRows() {
        int participantsSize = 5;
        Ladder ladder = new Ladder(1);
        ladder.build(participantsSize);
        LadderRow row = ladder.getRow(0);
        List<Boolean> lines = row.getIsLines();
        for (int i = 1; i < participantsSize - 1; i++) {
            Assertions.assertThat(lines.get(i) && lines.get(i - 1)).isFalse();
        }
    }
}
