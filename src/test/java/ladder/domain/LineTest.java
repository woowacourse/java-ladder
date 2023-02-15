package ladder.domain;

import static ladder.domain.LineStatus.GO;
import static ladder.domain.LineStatus.STOP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    @Test
    void 라인은_라인상태값을_가진다() {
        final Line line = new Line(List.of(GO, STOP, GO));

        assertThat(line.getLine()).containsExactly(GO, STOP, GO);
    }

}
