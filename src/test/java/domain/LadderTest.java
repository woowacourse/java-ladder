package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
    void createLadderWithEmptyLines(int ladderHeight) {
        //given
        //when
        Ladder ladder = new Ladder(ladderHeight);

        //then
        Assertions.assertThat(ladder.calculateTotalHeight()).isEqualTo(ladderHeight);
    }
}
