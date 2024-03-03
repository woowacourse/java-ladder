package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectStrategy;

class GameTest {

    @Test
    @DisplayName("멤버 이름 - 상품 이름 일괄 매핑 성공")
    void test_ok_findRewardMap() {
        Members members = Members.from(List.of("a", "b", "c", "d"));
        Height height = Height.from(3);
        Rewards rewards = Rewards.from(List.of("꽝", "100", "200", "300"));
        Game game = Game.of(members, height, rewards, () -> Connection.CONNECTED);
        Assertions.assertAll(
            () -> assertThat(game.findRewardMap().get("a")).isEqualTo("100"),
            () -> assertThat(game.findRewardMap().get("b")).isEqualTo("꽝"),
            () -> assertThat(game.findRewardMap().get("c")).isEqualTo("300"),
            () -> assertThat(game.findRewardMap().get("d")).isEqualTo("200")
        );
    }

    @Test
    @DisplayName("Game 생성 실패: 플레이어 수 != 상품 수")
    void test_exception_countNotEqual() {
        Members members = Members.from(List.of("a", "b", "c", "d"));
        Height height = Height.from(3);
        Rewards rewards = Rewards.from(List.of("꽝", "100", "200"));
        assertThatThrownBy(() -> Game.of(members, height, rewards, new RandomConnectStrategy()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("플레이어 수와 상품 수가 일치하지 않습니다.");
    }
}
