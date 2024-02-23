package laddergame.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import laddergame.domain.strategy.BuildStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인")
public class LineTest {
    Point truePoint = new Point(TRUE);
    Point falsePoint = new Point(FALSE);

    @Test
    @DisplayName("라인을 생성하는지 테스트한다.")
    public void createLineTest() {
        //given
        final int personCount = 4;
        final int expectedSize = personCount - 1;
        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Line line = new Line(personCount, buildStrategy);

        //then
        assertEquals(line.getPoints().points().size(), expectedSize);
    }

    @Test
    @DisplayName("랜덤값이 true일 경우 특정 위치에서 다리를 건설한다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final int position = 1;
        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Line line = new Line(personCount, buildStrategy);

        //then
        assertFalse(line.getPoints().points().get(position).isBuilt());
    }
}
