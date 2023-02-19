package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
    void createLadder() {
        //given
        int personCount = 5;
        int ladderHeight = 5;
        Height height = new Height(ladderHeight);

        //when
        Ladder ladder = Ladder.generateRandomly(height, personCount);

        //then
        assertThat(ladder.calculateTotalHeight()).isEqualTo(ladderHeight);
    }
}
