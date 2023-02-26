package ladder.domain;

import ladder.util.MockedPointGenerator;
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
        assertThat(ladderGame.getUnmodifiableLines())
                .hasSize(height);
    }

    @Test
    void 참여자들의_사다리타기를_수행한다() {

        Player juno = new Player("주노", 0);
        Player doi = new Player("도이", 1);
        Player boxster = new Player("박스터", 2);

        List<Player> playerDummy = List.of(juno, doi, boxster);

        List<Boolean> ladderDummy = List.of(
                true, false,
                false, false
        );

        LadderGame ladderGame = new LadderGame(new MockedPointGenerator(ladderDummy), new Players(playerDummy), 2);

        ladderGame.play();

        assertThat(doi.getPosition()).isEqualTo(0);
        assertThat(juno.getPosition()).isEqualTo(1);
        assertThat(boxster.getPosition()).isEqualTo(2);
    }
}
