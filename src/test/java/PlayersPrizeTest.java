import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Player;
import domain.result.PlayersPrize;
import domain.prize.Prize;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersPrizeTest {

    @Test
    @DisplayName("참여자에 해당하는 실행 결과를 반환한다.")
    void validSearch() {
        // given
        final Prize candy = new Prize("candy");
        final Prize cookie = new Prize("cookie");
        final PlayersPrize playersPrize = new PlayersPrize(Map.of(new Player("pobi"), candy, new Player("kirby"), cookie));

        // when & then
        assertThat(playersPrize.search("pobi")).isEqualTo(candy);
    }
}
