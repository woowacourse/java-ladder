package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LinesTest {

    @Test
    void 라인들은_주어진_높이만큼_생성된다() {
        int players = 3;
        int height = 3;
        Lines lines = new Lines(players, height);
        List<Line> result = lines.toUnModifiableLines();

        assertThat(result.size()).isEqualTo(height);
    }
}
