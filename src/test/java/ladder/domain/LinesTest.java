package ladder.domain;

import ladder.dto.LineResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.StepStatus.EXIST;
import static ladder.domain.StepStatus.NONE;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @DisplayName("사다리 높이 만큼의 Line을 생성한다.")
    @Test
    void createLines() {
        assertThat(Lines.of(() -> true, 3, 4).getLineResults().size())
                .isEqualTo(3);
    }

    @DisplayName("Lines의 값을 List<LineResult>형태로 가공해서 반환한다.")
    @Test
    void getLineResult() {
        assertThat(Lines.of(() -> true, 3, 4).getLineResults())
                .isEqualTo(List.of(
                        new LineResult(List.of(EXIST, NONE, EXIST)),
                        new LineResult(List.of(EXIST, NONE, EXIST)),
                        new LineResult(List.of(EXIST, NONE, EXIST))
                ));
    }
}
