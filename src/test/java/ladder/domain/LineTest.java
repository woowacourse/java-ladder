package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.StepStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("인원수 -1 개수 만큼의 포인트를 가진 Line 인스턴스를 생성한다.")
    @Test
    void createLine() {
        final Line line = new Line(() -> true, 4);

        assertThat(line.getStepStatuses().size())
                .isEqualTo(4 - 1);
    }

    @DisplayName("같은층에 연속된 EXIST가 존재하지 않는다.")
    @Test
    void notExistBetweenNextAndCurrent() {
        final Line line = new Line(() -> true, 4);

        assertThat(line.getStepStatuses().get(1))
                .isEqualTo(NONE);
    }
}
