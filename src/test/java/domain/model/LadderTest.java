package domain.model;

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
        Ladder ladder=new Ladder("2",3,()->true);
        List<Integer> expected= List.of(0,1,2);
        List<Integer> actual = new ArrayList<>();
        //when
        for(int index = 0; index <3; index++){
            int indexOfConsequence=ladder.goToConsequence(index,0);
            actual.add(indexOfConsequence);
        }
        //then
        assertThat(expected).isEqualTo(actual);
    }
}
