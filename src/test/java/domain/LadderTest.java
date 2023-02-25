package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;
import util.TrueGenerator;

public class LadderTest {
    @Test
    @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
    void createLadder() {
        //given
        int personCount = 5;
        int ladderHeight = 5;
        Height height = new Height(ladderHeight);

        //when
        Ladder ladder = Ladder.generate(new RandomBooleanGenerator(), height, personCount);

        //then
        assertThat(ladder.calculateTotalHeight()).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("한 사용자의 사다리 이동 결과 테스트")
    void testPlayerMove() {
        //given
        int personStartPosition = 0;
        int expectedDestination = 1;
        Ladder ladder = Ladder.generate(new TrueGenerator(), new Height(5), 4);

        //when
        int destination = ladder.findDestination(personStartPosition);

        //then
        assertThat(destination).isEqualTo(expectedDestination);
    }
}
