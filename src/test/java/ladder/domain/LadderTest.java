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
public class LadderTest {

    @Test
    void 사다리는_라인을_가진다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(false, false, true, false));
        final Ladder ladder = new Ladder(booleanGenerator, 2, 2);

        assertThat(ladder.getLines())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(DISCONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED)
                );
    }
}
