package laddergame.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
public class LadderTest {
    Point truePoint = new Point(TRUE);
    Point falsePoint = new Point(FALSE);

    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final Height height = new Height("4");
        final int playerCount = 4;

        //when
        Ladder ladder = new Ladder(playerCount, height);

        //then
        assertEquals(ladder.getLines().size(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getPoints().points().size(), playerCount - 1);
    }
}
