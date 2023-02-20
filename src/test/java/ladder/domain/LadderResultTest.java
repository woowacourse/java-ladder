package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class LadderResultTest {
    // 사다리 결과는 HashMap 을 갖는다.
    // 각 플레이어는 하나의 결과를 갖는다.
    @Test
    @DisplayName("플레이어는 하나의 결과를 갖는다.")
    void ladderResult_playerGetOneResult() {
        // given
        Map<Player, Item> result = new HashMap<>();
        Player player = new Player("vero");
        Item item = new Item("꽝");
        result.put(player, item);
        LadderResult ladderResult = new LadderResult(result);

        // expected
        Assertions.assertThat(ladderResult.getItemOfPlayer(player)).isEqualTo(item);
    }
}
