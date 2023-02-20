package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    private LadderGame initializeLadderGame(final List<String> names, final List<Boolean> ladder, final int height) {
        final Players players = Players.from(names);
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(ladder);

        return LadderGame.initialize(players, booleanGenerator, height);
    }

    @Test
    void 참가자들의_이름을_반환한다() {
        final LadderGame ladderGame = initializeLadderGame(List.of("name1", "name2"), List.of(true, true), 2);

        assertThat(ladderGame.getPlayers()).containsExactly("name1", "name2");
    }

    @Test
    void 생성된_사다리를_반환한다() {
        final LadderGame ladderGame = initializeLadderGame(List.of("name1", "name2"), List.of(true, true), 2);

        assertThat(ladderGame.getLadder())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(LineStatus.CONNECTED),
                        List.of(LineStatus.CONNECTED)
                );
    }
}
