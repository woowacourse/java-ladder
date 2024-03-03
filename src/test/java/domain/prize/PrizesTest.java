package domain.prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    void 입력된_게임_결과의_수가_플레이어_수와_같지_안으면_예외가_발생한다() {
        // given
        final Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1)
        ));

        // when
        final int playerCount = players.getPlayerCount();

        // then
        assertThatThrownBy(() -> new Prizes(List.of(new Prize("꽝")), playerCount))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Prizes는_인덱스에_해당하는_Prize를_반환한다() {
        // given
        Prizes prizes = new Prizes(List.of(
                new Prize("꽝1"),
                new Prize("꽝2"),
                new Prize("꽝3")
        ), 3);

        // when
        Prize foundPrize = prizes.findPrizeByIndex(1);

        // then
        assertEquals("꽝2", foundPrize.getValue());
    }

    @Test
    void 각_플레이어의_현재_위치에_대한_결과를_출력할_수_있다() {
        // given
        final List<Player> players = List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1)
        );

        Prizes prizes = new Prizes(List.of(
                new Prize("꽝1"),
                new Prize("꽝2")
        ), players.size());

        final Prize prize1 = prizes.findPrizeByIndex(players.get(0).getPosition());
        final Prize prize2 = prizes.findPrizeByIndex(players.get(1).getPosition());

        assertThat(prize1.getValue()).isEqualTo("꽝1");
        assertThat(prize2.getValue()).isEqualTo("꽝2");
    }
}
