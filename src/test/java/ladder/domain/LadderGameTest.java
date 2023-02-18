package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderGameTest {

    private final List<Player> players = List.of(
            new Player("도이"),
            new Player("주노")
    );

    @Test
    void 사다리는_높이_만큼의_라인을_가진다() {
        int height = 4;
        LadderGame ladderGame = new LadderGame(new Players(players), height);
        assertThat(ladderGame.toUnmodifiableLines())
                .hasSize(height);
    }

    @Test
    void 사다리는_주어진_인원_수_만큼의_참가자를_가진다() {
        int height = 4;
        LadderGame ladderGame = new LadderGame(new Players(players), height);
        assertThat(ladderGame.toUnmodifiablePlayers())
                .hasSize(players.size());
    }
}
