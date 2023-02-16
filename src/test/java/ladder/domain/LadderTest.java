package ladder.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderTest {

    @Test
    void 사다리는_라인을_가진다() {
        final int height = 2;
        final int width = 1;
        final Ladder ladder = new Ladder(() -> true, height, width);

        assertThat(ladder.getLines()).containsExactly(
                new Line(List.of(LineStatus.CONNECTED)),
                new Line(List.of(LineStatus.CONNECTED))
        );
    }

    @Test
    void 사다리는_겹칠_수_없다() {
        final int height = 1;
        final int width = 2;
        final Ladder ladder = new Ladder(() -> true, height, width);

        assertThat(ladder.getLines()).containsExactly(
                new Line(List.of(LineStatus.CONNECTED, LineStatus.DISCONNECTED))
        );
    }

}
