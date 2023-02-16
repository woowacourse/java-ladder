package ladder.domain;

import static ladder.domain.LineStatus.CONNECTED;
import static ladder.domain.LineStatus.DISCONNECTED;
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
        final Line line = new Line(List.of(CONNECTED, DISCONNECTED, CONNECTED));

        assertThat(line.getLine()).containsExactly(CONNECTED, DISCONNECTED, CONNECTED);
    }

}
