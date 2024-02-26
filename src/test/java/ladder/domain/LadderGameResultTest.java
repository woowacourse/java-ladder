package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import ladder.domain.player.Player;
import ladder.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameResultTest {

    static final Player PLAYER1 = new Player("pobi");
    static final Player PLAYER2 = new Player("jin");
    static final Player NOT_PARTICIPANT = new Player("jk");
    static final Product PRODUCT1 = new Product("꽝");
    static final Product PRODUCT2 = new Product("3000");

    @DisplayName("플레이어에 따른 상품 결과를 줄 수 있다")
    @Test
    void findResultTest() {
        Map<Player, Product> results = Map.of(PLAYER1, PRODUCT1, PLAYER2, PRODUCT2);
        LadderGameResult ladderGameResult = new LadderGameResult(results);

        Product actual = ladderGameResult.findResult(PLAYER1);

        assertThat(actual).isEqualTo(PRODUCT1);
    }

    @DisplayName("참여하지 않은 플레이어로 요청할 경우, 예외를 던진다")
    @Test
    void findResultTest_usingNotParticipantPlayer_throwException() {
        Map<Player, Product> results = Map.of(PLAYER1, PRODUCT1, PLAYER2, PRODUCT2);
        LadderGameResult ladderGameResult = new LadderGameResult(results);

        assertThatThrownBy(() -> ladderGameResult.findResult(NOT_PARTICIPANT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 플레이어는 게임에 참여하지 않았습니다");
    }
}
