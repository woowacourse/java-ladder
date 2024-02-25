package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @DisplayName("사다리 높이 만큼의 Line을 생성한다.")
    @Test
    void createLines() {
        assertThat(Lines.of(() -> true, 3, 4).getLines().size())
                .isEqualTo(3);
    }

    @DisplayName("사다리가 가진 모든 Line의 Step의 위치를 반환한다.")
    @Test
    void findStepPositions() {
        Lines lines = Lines.of(() -> true, 3, 4);

        assertThat(lines.findStepPositions()).containsExactly(List.of(0, 2), List.of(0, 2), List.of(0, 2));
    }
}
