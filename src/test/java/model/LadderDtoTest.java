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
        Height height = new Height(4);
        Players players = new Players(List.of("redy", "anna", "brown", "bee", "bibi"));
        Prizes prizes = Prizes.of(List.of("1", "2", "3", "4", "5"), players.size());

        List<String> expected = List.of("|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |");

        //when
        Ladder ladder = createNothingBuildLadder(height, players, prizes);
        LadderDto ladderDto = LadderDto.from(ladder.getLines());

        //then
        Assertions.assertThat(ladderDto.ladder()).isEqualTo(expected);
    }
}
