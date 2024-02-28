package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderGameTest {
    @Test
    @DisplayName("사다리게임을 만든다")
    void makeLadderGame() {
        //given
        Ladder ladder = new Ladder("2", 2);
        People people=new People(List.of("a","b"));
        ResultCandidate resultCandidate=new ResultCandidate(List.of("꽝","100"));
        //when
        LadderGame ladderGame=new LadderGame(ladder,people,resultCandidate);
        //then
        assertThatCode(()->new LadderGame(ladder,people,resultCandidate)).doesNotThrowAnyException();
    }
}
