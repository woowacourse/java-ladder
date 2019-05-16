package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 중복_가로줄_검사_get() {
        List<Boolean> line = (new Line(5)).getHorizon();
        for (int i = 0; i < line.size() - 1; i++) {
            assertThat(line.get(i) && line.get(i + 1)).isEqualTo(false);
        }
    }

    @Test
    void 가로선_중복_생성_생성자() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Line(Arrays.asList(false, true, true));
        });
    }

    @Test
    void 왼쪽_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.moveRightOrLeft(0)).isEqualTo(0);
    }

    @Test
    void 오른쪽_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.moveRightOrLeft(2)).isEqualTo(2);
    }
    @Test
    void 가운데_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.moveRightOrLeft(1)).isEqualTo(2);
    }
}
