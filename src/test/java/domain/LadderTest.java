package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TrueGenerator;

public class LadderTest {
    @Test
    @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
    void createLadderWithEmptyLines() {
        //given
        int personCount = 5;
        int ladderHeight = 3;
        Height height = new Height(ladderHeight);
        Ladder ladder = new Ladder(height, personCount);

        //when
        //then
        Assertions.assertThat(ladder.calculateTotalHeight()).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadder() {
        //given
        int personCount = 5;
        Height height = new Height(2);
        Ladder ladder = new Ladder(height, personCount);

        //when
        ladder.generate(new TrueGenerator());

        //then
        Assertions.assertThat(ladder.getStatus())
                .containsExactly(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY),
                        List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY));
    }
}
