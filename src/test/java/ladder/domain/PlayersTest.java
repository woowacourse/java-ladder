package ladder.domain;

import ladder.util.MockedPointGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayersTest {

    @Test
    void 참여자들이_한명_이하면_예외() {
        List<Player> dummy = List.of(new Player("주노"));

        assertThatThrownBy(() -> {
            new Players(dummy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자들이_라인을_이동한다() {
        Player juno = new Player("주노", 0);
        Player doi = new Player("도이", 1);
        Player boxster = new Player("박스터", 2);

        List<Player> dummy = List.of(juno, doi, boxster);

        Players players = new Players(dummy);
        players.moveAll(new Line(
                new MockedPointGenerator(List.of(true, false)),
                dummy.size() - 1)
        );

        assertThat(doi.getPosition()).isEqualTo(0);
        assertThat(juno.getPosition()).isEqualTo(1);
        assertThat(boxster.getPosition()).isEqualTo(2);

    }
}
