package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("각 라인 별 발판의 존재 여부를 가진다.")
    void status() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
        Line line = new Line(rungs);
        assertThat(rungs).isEqualTo(line.getRungs());
    }
}
