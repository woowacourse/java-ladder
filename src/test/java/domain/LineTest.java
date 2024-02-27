package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("현재 생성된 Bridge 갯수를 리턴하는 기능")
    @Test
    public void getPointCount() {
        assertThat(new Line(5, new FixedBooleanGenerator(true)).getBridgeCount())
                .isEqualTo(4);
    }

    @DisplayName("연속으로 이어진 다리는 존재하지 않는다")
    @Test
    public void createLineNonContinuous() {
        Line line = new Line(4, new FixedBooleanGenerator(true));
        assertThat(line.getBridgesInformation()).isEqualTo(List.of(true, false, true));
    }

    @Test
    @DisplayName("해당 라인에서 이동한 이후의 index를 반환한다.")
    void getNextPosition() {
        Line line = new Line(4, new FixedBooleanGenerator(true));

        int startIndex = 2;
        int expected = 3;

        assertThat(line.getNextPosition(startIndex)).isEqualTo(expected);
    }
}

