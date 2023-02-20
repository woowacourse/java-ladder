package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_LEFT = -1;
    private static final int DIRECTION_DOWN = 0;


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
    @DisplayName("n번째 위치에서 어디로갈지 알려주는 테스트")
    void decideDirectionTest() {
        List<Bar> bars =List.of(Bar.MOVABLE_BAR, Bar.UNMOVABLE_BAR, Bar.UNMOVABLE_BAR);
        Line line = new Line(bars);

        assertThat(line.decideDirection(0)).isEqualTo(DIRECTION_RIGHT);
        assertThat(line.decideDirection(1)).isEqualTo(DIRECTION_LEFT);
        assertThat(line.decideDirection(2)).isEqualTo(DIRECTION_DOWN);
    }

}
