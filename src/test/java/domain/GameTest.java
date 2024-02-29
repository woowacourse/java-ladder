package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("멤버 이름 - 상품 이름 일괄 매핑 성공")
    void test_ok_findRewardMap() {
        Members members = Members.from("a,b,c,d");
        Height height = Height.from("3");
        Rewards rewards = Rewards.from(4, "꽝, 100, 200, 300");
        Game game = Game.of(members, height, rewards, () -> Connection.CONNECTED);
        Assertions.assertAll(
            () -> assertThat(game.findRewardMap().get("a")).isEqualTo("100"),
            () -> assertThat(game.findRewardMap().get("b")).isEqualTo("꽝"),
            () -> assertThat(game.findRewardMap().get("c")).isEqualTo("300"),
            () -> assertThat(game.findRewardMap().get("d")).isEqualTo("200")
        );
    }
}
