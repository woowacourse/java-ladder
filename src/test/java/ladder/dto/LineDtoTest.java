package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Line;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineDtoTest {

    @Test
    @DisplayName("dto로 변환한다.")
    void toDto() {
        BooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true));
        Line line = new Line(2, booleanGenerator);

        LineDto lineDto = LineDto.from(line);
        List<Boolean> rungsExist = lineDto.rungsExist();

        assertThat(rungsExist).containsExactly(true);
    }
}
