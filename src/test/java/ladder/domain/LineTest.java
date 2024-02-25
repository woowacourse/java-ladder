package ladder.domain;

import static ladder.domain.StepStatus.EXIST;
import static ladder.domain.StepStatus.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("인원수 -1 개수 만큼의 StepStatus들을 가진 Line 인스턴스를 생성한다.")
    @Test
    void createLine() {
        final Line line = new Line(() -> true, 4);

        assertThat(line.getLine().size()).isEqualTo(3);
    }

    @DisplayName("같은층에 연속된 EXIST가 존재하지 않는다.")
    @Test
    void notExistBetweenNextAndCurrent() {
        final Line line = new Line(() -> true, 4);

        assertThat(line.getLine().get(1)).isEqualTo(NONE);
    }

    @DisplayName("List<StepStatus>를 LineResult 형태로 가공해서 반환한다.")
    @Test
    void getLineResult() {
        final Line line = new Line(() -> true, 4);

        assertThat(line.getLine()).containsExactly(EXIST, NONE, EXIST);
    }

    @DisplayName("StepStatus가 EXIST인 인덱스의 위치를 반환한다.")
    @Test
    void findStepPosition() {
        Line line = new Line(() -> true, 4);

        assertThat(line.findStepPosition()).containsExactly(0, 2);
    }
}
