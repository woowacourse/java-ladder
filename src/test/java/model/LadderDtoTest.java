package model;

import static model.LadderTest.createNothingBuildLadder;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderDtoTest {

    @Test
    @DisplayName("사다리 모양의 객체를 반환한다.")
    void createFormattedLadder() {
        //given
        int personCount = 5;
        Height height = new Height(4);

        List<String> expected = List.of("|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |");

        //when
        Ladder ladder = createNothingBuildLadder(height, personCount);
        LadderDto ladderDto = LadderDto.from(ladder.getLines());

        //then
        Assertions.assertThat(ladderDto.ladder()).isEqualTo(expected);
    }
}
