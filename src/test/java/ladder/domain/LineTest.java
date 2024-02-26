package ladder.domain;

import ladder.dto.LineResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.PathStatus.EXIST;
import static ladder.domain.PathStatus.NONE;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("인원수 -1 개수 만큼의 포인트를 가진 Line 인스턴스를 생성한다.")
    @Test
    void createLine() {
        final Line line = new Line(() -> true, 4);
        final LineResult lineResult = LineResult.of(line);
        final int expected = 4 - 1;

        assertThat(lineResult.value().size())
                .isEqualTo(expected);
    }

    @DisplayName("같은층에 연속된 EXIST가 존재하지 않는다.")
    @Test
    void notExistBetweenNextAndCurrent() {
        final Line line = new Line(() -> true, 4);
        final LineResult lineResult = LineResult.of(line);

        assertThat(lineResult.value().get(1))
                .isEqualTo(NONE);
    }

    @DisplayName("List<StepStatus>를 LineResult 형태로 가공해서 반환한다.")
    @Test
    void getLineResult() {
        final Line line = new Line(() -> true, 4);
        final LineResult lineResult = LineResult.of(line);

        assertThat(lineResult.value())
                .containsExactly(EXIST, NONE, EXIST);
    }
}
