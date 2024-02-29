package model.player;

import model.players.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("플레이어 생성 테스트")
    void createPlayer() {
        String name = "pobi";
        Assertions.assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어의 이름이 5자 초과여서 오류가 발생한다.")
    void invalidNameLength() {
        String name = "pobipobi";
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
