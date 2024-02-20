package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @DisplayName("사다리 높이 만큼의 Line을 생성한다.")
    @Test
    void createLines() {
        assertThat(Lines.of(3, 4).getLines().size())
                .isEqualTo(3);
    }
}
