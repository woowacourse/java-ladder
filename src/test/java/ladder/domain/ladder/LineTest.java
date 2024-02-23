package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("라인 내 발판들을 생성한다.")
    void generateRungs() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY);
        Line line = new Line(3, new MockRungGenerator(rungs));

        assertThat(line.getRungs()).containsExactly(Rung.EXIST, Rung.EMPTY);
    }

    @Test
    @DisplayName("연속된 발판들은 생성되지 않는다.")
    void invalidGenerateRungsV1() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EXIST);
        Line line = new Line(3, new MockRungGenerator(rungs));

        assertThat(line.getRungs()).containsExactly(Rung.EXIST, Rung.EMPTY);
    }
}
