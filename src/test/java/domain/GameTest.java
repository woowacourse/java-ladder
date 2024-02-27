package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("멤버 이름으로 당첨된 상품 이름 찾기 성공")
    void findRewardNameByMemberName() {
        Members members = Members.from("a,b,c,d");
        Lines lines = Lines.of(4, Height.from("3"), () -> Point.CONNECTED);
        Rewards rewards = Rewards.from(4, "꽝, 100, 200, 300");
        Game game = Game.of(members, lines, rewards);
        Assertions.assertAll(
            () -> assertThat(game.findRewardNameByMemberName("a")).isEqualTo("100"),
            () -> assertThat(game.findRewardNameByMemberName("b")).isEqualTo("꽝"),
            () -> assertThat(game.findRewardNameByMemberName("c")).isEqualTo("300"),
            () -> assertThat(game.findRewardNameByMemberName("d")).isEqualTo("200")
        );
    }
}
