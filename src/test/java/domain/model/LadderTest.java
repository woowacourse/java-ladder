package domain.model;

import domain.model.ladder.Height;
import domain.model.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("출발점으로부터 사다리를 타고 도착점을 반환한다.")
    void findConsequenceTest() {
        //given
        Ladder ladder = new Ladder(new Height("2"), 3, () -> true);
        List<Integer> expected = List.of(0, 1, 2);
        List<Integer> actual = new ArrayList<>();

        //when
        int consequenceForPosition0 = ladder.goToConsequence(0, 0);
        actual.add(consequenceForPosition0);

        int consequenceForPosition1 = ladder.goToConsequence(1, 0);
        actual.add(consequenceForPosition1);

        int consequenceForPosition2 = ladder.goToConsequence(2, 0);
        actual.add(consequenceForPosition2);

        //then
        assertThat(expected).isEqualTo(actual);
    }
}
