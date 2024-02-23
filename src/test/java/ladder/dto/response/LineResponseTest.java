package ladder.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineResponseTest {

    @Test
    @DisplayName("dto로 변환한다.")
    void toDto() {
        List<Rung> rungs = List.of(Rung.EXIST);
        RungGenerator rungGenerator = new MockRungGenerator(rungs);
        Line line = new Line(2, rungGenerator);

        LineResponse lineResponse = LineResponse.from(line);
        List<Boolean> rungsExist = lineResponse.rungsExist();

        assertThat(rungsExist).containsExactly(true);
    }
}
