package domain.prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.player.Name;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    void Results는_인덱스에_해당하는_Result를_반환한다() {
        Prizes prizes = new Prizes(List.of(
                new Prize("꽝1"),
                new Prize("꽝2"),
                new Prize("꽝3")));

        Prize foundPrize = prizes.findPrizeByIndex(1);
        assertEquals("꽝2", foundPrize.getValue());
    }

    @Test
    void 각_플레이어의_현재_위치에_대한_결과를_출력할_수_있다() {
        // given
        Players players = new Players(List.of(
                new Name("name1"),
                new Name("name2")
        ));

        Prizes prizes = new Prizes(List.of(
                new Prize("꽝1"),
                new Prize("꽝2")));

        final Prize prize1 = prizes.findResultByPlayer(players.findPlayerByIndex(0));
        final Prize prize2 = prizes.findResultByPlayer(players.findPlayerByIndex(1));

        assertThat(prize1.getValue()).isEqualTo("꽝1");
        assertThat(prize2.getValue()).isEqualTo("꽝2");
    }
}
