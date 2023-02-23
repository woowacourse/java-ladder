package ladder.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.PlayerResults;
import ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResultsResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void of_success() {
        // given
        PlayerResult result1 = new PlayerResult(new Player("glen"), new Prize("1000"));
        PlayerResult result2 = new PlayerResult(new Player("pobi"), new Prize("꽝"));
        PlayerResult result3 = new PlayerResult(new Player("bero"), new Prize("5000"));
        PlayerResults playerResults = new PlayerResults(List.of(result1, result2, result3));

        // when
        PlayerResultsResponse playerResultsResponse = PlayerResultsResponse.of(playerResults);

        // then
        assertThat(playerResultsResponse.getPlayerResults())
                .containsExactly("glen : 1000", "pobi : 꽝", "bero : 5000");
    }
}
