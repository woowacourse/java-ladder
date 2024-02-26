package laddergame.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(line.getPoints().getPointSize(), expectedSize);
    }

    @Test
    @DisplayName("랜덤값이 true일 경우 해당 위치에서 다리를 건설한다.")
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

    @Test
    @DisplayName("주어진 위치를 제외한 곳에 사다리 다리 건설시 예외를 발생한다.")
    public void buildBridgeExceptionTest() {
        //given
        final int personCount = 4;
        BuildStrategy buildStrategy1 = count -> new Points(List.of(truePoint, falsePoint, truePoint, truePoint));
        BuildStrategy buildStrategy2 = count -> new Points(List.of(truePoint, falsePoint, truePoint, falsePoint));
        BuildStrategy buildStrategy3 = count -> new Points(List.of(truePoint, falsePoint));

        //when & then
        assertAll(() -> {
            assertThrows(IllegalStateException.class, () -> new Line(personCount, buildStrategy1));
            assertThrows(IllegalStateException.class, () -> new Line(personCount, buildStrategy2));
            assertThrows(IllegalStateException.class, () -> new Line(personCount, buildStrategy3));
        });
    }
}
