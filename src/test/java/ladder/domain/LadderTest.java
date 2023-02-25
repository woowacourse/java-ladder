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
public class LadderTest {

    @Test
    void 높이와_너비를_받아_사다리를_생성한다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(false, false, true, false));
        final Ladder ladder = Ladder.generate(booleanGenerator, 2, 2);

        assertThat(ladder.getLines())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(DISCONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED)
                );
    }

    @ParameterizedTest(name = "한 위치에 대한 사다리 게임을 진행한다. start: {0} end: {1}")
    @CsvSource({"0,1", "1,3", "2,2", "3,0"})
    void 한_위치에_대한_사다리게임을_진행한다(final int startPosition, final int endPosition) {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(
                false, false, true,
                false, true, false,
                true, false, true
        ));
        final Ladder ladder = Ladder.generate(booleanGenerator, 3, 3);
        final Position position = Position.valueOf(startPosition);

        Position result = ladder.play(position);

        assertThat(result).isEqualTo(Position.valueOf(endPosition));
    }
}
