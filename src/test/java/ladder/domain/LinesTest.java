package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LinesTest {

    @Test
    void 라인들은_주어진_높이만큼_생성된다() {
        int width = 13;
        int height = 3;
        Lines lines = new Lines(height, width);
        List<Line> result = lines.toUnModifiableLines();

        assertThat(result.size()).isEqualTo(height);
    }
}
