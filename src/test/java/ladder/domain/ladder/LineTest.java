package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private final List<Bar> bars = List.of(Bar.MOVABLE_BAR, Bar.UNMOVABLE_BAR);
    private Line line;

    @BeforeEach
    void setup() {
        line = new Line(bars);
    }

    @Test
    @DisplayName("Line의 가로 라인이 겹치지 않는지 확인한다.")
    void getLineTest() {
        List<Bar> bars = line.getLine();

        for (int idx = 0; idx < bars.size() - 1; idx++) {
            Bar currentBar = bars.get(idx);
            Bar nextBar = bars.get(idx + 1);

            assertThat(!currentBar.getValue() || !nextBar.getValue())
                    .isTrue();
        }
    }

    @Test
    @DisplayName("생성된 Line의 변수가 입력한 값과 같은 값을 포함하는지 확인한다")
    void checkLineTest() {
        assertThat(line.getLine())
                .isEqualTo(bars);
    }

    @Test
    @DisplayName("이동한 위치를 반환하는 기능 테스트")
    void movePositionTest() {
        List<Bar> bars =List.of(Bar.MOVABLE_BAR, Bar.UNMOVABLE_BAR, Bar.UNMOVABLE_BAR);
        Line line = new Line(bars);

        assertThat(line.nextPosition(0)).isEqualTo(1);
        assertThat(line.nextPosition(1)).isEqualTo(0);
        assertThat(line.nextPosition(2)).isEqualTo(2);
    }
}
