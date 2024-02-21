package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
public class LadderTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final int height = 4;
        final int playerCount = 4;

        //when
        Ladder ladder = new Ladder(playerCount, height);

        //then
        assertEquals(ladder.getLines().size(), height);
        assertEquals(ladder.getLines().get(0).getPoints().size(), playerCount - 1);
    }
}
