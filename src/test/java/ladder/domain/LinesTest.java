package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @DisplayName("사다리 높이 만큼의 Line을 생성한다.")
    @Test
    void createLines() {
        assertThat(Lines.of(() -> true, 3, 4).getLines().size())
                .isEqualTo(3);
    }
}
