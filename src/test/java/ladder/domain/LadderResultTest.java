package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(ladderResult.getItemOfPlayer(player)).isEqualTo(item);
    }

    @Test
    @DisplayName("없는 플레이어의 결과를 가져오는 경우 예외를 던진다.")
    void ladderResult_throwException_notExistPlayer() {
        // given
        LadderResult ladderResult = new LadderResult(new HashMap<>());

        // expected
        assertThatThrownBy(() -> ladderResult.getItemOfPlayer(new Player("vero")))
                .isInstanceOf(IllegalStateException.class);
    }
}
