package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(true, true));
        final List<String> names = List.of("name1", "name2");
        final int height = 2;
        ladderGame = new LadderGame(booleanGenerator, names, height);
    }

    @Test
    void 참가자들의_이름을_반환한다() {
        assertThat(ladderGame.getPlayers()).containsExactly("name1", "name2");
    }

    @Test
    void 생성된_사다리를_반환한다() {
        assertThat(ladderGame.getLadder())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(LineStatus.CONNECTED),
                        List.of(LineStatus.CONNECTED)
                );
    }
}
