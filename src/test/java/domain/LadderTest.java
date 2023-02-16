package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.TrueGenerator;

public class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
    void createLadderWithEmptyLines(int ladderHeight) {
        //given
        int personCount = 5;
        Height height = new Height(ladderHeight);

        //when
        Ladder ladder = new Ladder(height, personCount);

        //then
        Assertions.assertThat(ladder.calculateTotalHeight()).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadder() {
        //given
        int personCount = 5;
        Height height = new Height(2);

        //when
        Ladder ladder = new Ladder(height, personCount);
        ladder.generateLadder(new TrueGenerator());

        //then
        Assertions.assertThat(ladder.getStatus())
                .containsExactly(List.of(true, false, true, false), List.of(true, false, true, false));
    }
}
