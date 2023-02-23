package laddergame.domain;

import laddergame.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RewardsTest {
    static private Validator validator;

    @BeforeAll
    static void setup() {
        validator = new Validator();
    }

    @DisplayName("입력 목록 중에 공백이 입력되었을 때 에러 확인")
    @Test
    void checkBlank() {
        Players players = new Players(List.of("one", "two"));
        Assertions.assertThatThrownBy(() -> validator.validateRewards(List.of(" ", "jena"), players.getPlayersCount())).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 목록이 '꽝' 아니면 숫자만 입력되지 않았을 때 에러 확인")
    @Test
    void checkContent() {
        Assertions.assertThatThrownBy(() -> new Rewards(List.of("꽈앙"))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Rewards(List.of("2500", "abc"))).isInstanceOf(IllegalArgumentException.class);
        assertDoesNotThrow(() -> new Rewards(List.of("꽝")));
        assertDoesNotThrow(() -> new Rewards(List.of("꽝", "3000")));
        Assertions.assertThatThrownBy(() -> new Rewards(List.of("3000", "-1"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보상 목록 수가 플레이어 수와 같지 않을때 에러 확인")
    @Test
    void checkRewardCount() {
        Rewards rewards = new Rewards(List.of("꽝", "3000"));
        Players players = new Players(List.of("jena", "pobi", "crong"));
        Assertions.assertThatThrownBy(() -> validator.validateRewards(rewards.getRewards(), players.getPlayersCount()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
