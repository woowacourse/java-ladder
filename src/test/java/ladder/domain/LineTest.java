package ladder.domain;

import static ladder.domain.LineStatus.CONNECTED;
import static ladder.domain.LineStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    @Test
    void 라인은_너비를_받아_너비_만큼의_연결_상태값을_생성한다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, false, true, false, false));
        final Line line = Line.generate(booleanGenerator, 5);

        assertThat(line.getLine()).containsExactly(CONNECTED, DISCONNECTED, CONNECTED, DISCONNECTED, DISCONNECTED);
    }

    @Test
    void 가로_라인의_연결_상태값이_연속으로_연결됨일_수_없다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, true, true, true, true));
        final Line line = Line.generate(booleanGenerator, 5);

        assertThat(line.getLine()).containsExactly(CONNECTED, DISCONNECTED, CONNECTED, DISCONNECTED, CONNECTED);
    }

    @ParameterizedTest(name = "가로라인 한 줄에 대한 사다리 게임을 진행한다. start: {0} end: {1}")
    @CsvSource({"0,1", "1,0", "2,3", "3,2", "4,4", "5,5"})
    void 가로라인_한_줄에_대한_사다리게임을_진행한다(final int startPosition, final int endPosition) {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, false, true, false, false));
        final Line line = Line.generate(booleanGenerator, 5);
        final Position position = Position.valueOf(startPosition);

        Position result = line.play(position);

        assertThat(result).isEqualTo(Position.valueOf(endPosition));
    }
}
