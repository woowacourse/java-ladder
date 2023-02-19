package ladder.domain;

import static ladder.domain.LineStatus.CONNECTED;
import static ladder.domain.LineStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderTest {

    @Test
    void 사다리는_라인을_가진다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(false, false, true, false));
        final Ladder ladder = getLadder(booleanGenerator, 2, 2);

        assertThat(ladder.getLines())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(DISCONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED)
                );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    void 사다리의_높이가_1미만_100초과시_예외를_던진다(int height) {
        assertThatThrownBy(() -> getLadder(() -> true, height, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 1, 최대 100까지 가능합니다.");
    }

    private static Ladder getLadder(final BooleanGenerator booleanGenerator, final int height, final int width) {
        return new Ladder(booleanGenerator, height, width);
    }
}
