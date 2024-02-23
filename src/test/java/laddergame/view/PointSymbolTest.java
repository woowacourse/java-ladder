package laddergame.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import laddergame.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("포인트 기호")
class PointSymbolTest {
    @Test
    @DisplayName("포인트 값에 따라 적절한 기호를 결정한다.")
    public void selectSymbolTest() {
        //given
        boolean point = true;
        boolean empty = false;

        //when & then
        assertEquals(PointSymbol.getSymbol(new Point(point)), "-----");
        assertEquals(PointSymbol.getSymbol(new Point(empty)), "     ");
    }
}