import domain.Ladder;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    @Test
    @DisplayName("Ladder를 생성한다")
    void createLadder() {
        //given

        //when

        //then
        assertThatCode(() -> new Ladder()).doesNotThrowAnyException();
    }
    
    @Test
    @DisplayName("사람 수와 높이로 Ladder 생성")
    void createLadderWithPersonCountAndMaxHeight() throws Exception {
        //given
        int maxHeight = 4;
        int personCount = 4;
        //when
        //then
        assertThatCode(()->new Ladder(personCount,maxHeight)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리를 생성한다")
    void generate() {
        //given
        int maxHeight = 4;
        int personCount = 4;
        //when
        Ladder ladder = new Ladder(maxHeight, personCount);
        ladder.generate();
        //then
        assertThat(maxHeight).isEqualTo(ladder.getMaxHeight());
    }

    

}
