package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    void 중복된_이름이_존재하면_예외가_발생한다() {
        // given
        final List<Player> players = List.of(
                new Player(new Name("same"), 0),
                new Player(new Name("same"), 1),
                new Player(new Name("uniq"), 2)
        );

        // when & then
        assertThatThrownBy(() -> new Players(players))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름이_없으면_예외가_발생하지_않는다() {
        // given
        final List<Player> players = List.of(
                new Player(new Name("uniq1"), 0),
                new Player(new Name("uniq2"), 1),
                new Player(new Name("uniq3"), 2)
        );

        // when & then
        assertDoesNotThrow(() -> new Players(players));
    }

    @Test
    void 각_플레이어를_인덱스별로_조회할_수_있다() {
        // given
        final Player player1 = new Player(new Name("name1"), 0);
        final Player player2 = new Player(new Name("name2"), 1);
        final Players players = new Players(List.of(player1, player2));

        // when & then
        assertEquals(player1, players.findPlayerByIndex(0));
        assertEquals(player2, players.findPlayerByIndex(1));
    }

    @Test
    void 범위를_벗어난_인덱스로_조회시_예외가_발생한다() {
        // given
        final Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1)
        ));

        // when
        int outOfBoundIndex = 2;

        // when & then
        assertThatThrownBy(() -> players.findPlayerByIndex(outOfBoundIndex))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_플레이어를_이름으로_조회할_수_있다() {
        // given
        final Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1)
        ));

        // when
        String name = "name1";

        // then
        assertEquals(name, players.findPlayerByName(name).getName());
    }

    @Test
    void 존재하지_않는_이름으로_조회시_예외가_발생한다() {
        // given
        final Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1)
        ));

        // when
        String invalidName = "ddang";

        // then
        assertThatThrownBy(() -> players.findPlayerByName(invalidName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
