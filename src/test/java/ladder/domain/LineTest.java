package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void true_다음_true_검사() {
        List<Boolean> testLine = (new Line(5)).getHorizontal();
        for (int i = 0; i < testLine.size() - 1; i++) {
            assertThat(testLine.get(i) && testLine.get(i + 1)).isEqualTo(false);
        }
    }
    @Test
    void 세로줄세개_맨_왼쪽에서_시작_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.moveHorizontal(0)).isEqualTo(0);
    }
    @Test
    void 세로줄세개_맨_오른쪽에서_시작_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.moveHorizontal(2)).isEqualTo(2);
    }
    @Test
    void 세로줄세개_가운데시작_맨오른쪽끝_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.moveHorizontal(1)).isEqualTo(2);
    }
    @Test
    void 세로줄세개_가운데시작_맨왼쪽끝_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.moveHorizontal(1)).isEqualTo(0);
    }
    @Test
    void 가로선_중복_생성_오류() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Line(Arrays.asList(false, true, true));
        });
    }
}
