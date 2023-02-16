package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class PointTest {

    private static final String TRUE_MESSAGE = "-----";
    private static final String FALSE_MESSAGE = "     ";

    @Test
    @DisplayName("포인트의 값이 true일 때 '-----'를 출력한다.")
    void getPointTrueMessage() {
        boolean flag = true;
        assertThat(Point.getPoint(flag).getMessage()).isEqualTo(TRUE_MESSAGE);
    }

    @Test
    @DisplayName("포인트의 값이 false일 때 '     '를 출력한다.")
    void getPointFalseMessage() {
        boolean flag = false;
        assertThat(Point.getPoint(flag).getMessage()).isEqualTo(FALSE_MESSAGE);
    }
}
