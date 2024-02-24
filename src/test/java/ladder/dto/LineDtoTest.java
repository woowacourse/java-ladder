package ladder.dto;

import ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineDtoTest {

    @Test
    @DisplayName("dto로 변환한다.")
    void toDto() {
        Line line = new Line(List.of(true));

        LineDto lineDto = LineDto.from(line);
        List<Boolean> rungsExist = lineDto.rungsExist();

        assertThat(rungsExist).containsExactly(true);
    }
}
