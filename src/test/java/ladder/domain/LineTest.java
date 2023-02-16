package ladder.domain;

import static ladder.domain.LineStatus.CONNECTED;
import static ladder.domain.LineStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    @Test
    void 라인은_너비를_받아_라인상태값을_생성한다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, false, true, false, false));
        final Line line = new Line(booleanGenerator, 5);

        assertThat(line.getLine()).containsExactly(CONNECTED, DISCONNECTED, CONNECTED, DISCONNECTED, DISCONNECTED);
    }

    @Test
    void 가로_라인의_상태가_연속으로_연결됨_상태일_수_없다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, true, true, true, true));
        final Line line = new Line(booleanGenerator, 5);

        assertThat(line.getLine()).containsExactly(CONNECTED, DISCONNECTED, CONNECTED, DISCONNECTED, CONNECTED);
    }
}
