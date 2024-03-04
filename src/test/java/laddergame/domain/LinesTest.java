package laddergame.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import laddergame.domain.strategy.BuildStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인들")
class LinesTest {
    Point truePoint = new Point(TRUE);
    Point falsePoint = new Point(FALSE);

    @Test
    @DisplayName("생성에 성공한다.")
    public void createLinesTest() {
        //given
        final Height height = new Height("1");
        final String playerName1 = "choco";
        final String playerName2 = "lemon";
        final String playerName3 = "lime";

        final Players players = Players.from(List.of(playerName1, playerName2, playerName3));
        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint));

        //when
        final Lines lines = Lines.from(height, players, buildStrategy);

        //then
        assertEquals(lines.getLine(0).getPoints().getPointSize(), 2);
        assertEquals(lines.getDirection(0, 0), Direction.RIGHT);
        assertEquals(lines.getDirection(0, 1), Direction.LEFT);
        assertEquals(lines.getDirection(0, 2), Direction.NONE);
    }
}
