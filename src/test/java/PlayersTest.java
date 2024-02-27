import domain.Player;
import domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {
    @DisplayName("중복된 이름이 있으면 예외를 발생시킨다.")
    @Test
    void duplicatePlayer() {
        Assertions.assertThatThrownBy(() -> Players.from(List.of("bito", "kirby", "bito")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 인원 수를 반환한다.")
    @Test
    void getCount() {
        Assertions.assertThat(Players.from(List.of("bito", "kirby")).getCount()).isEqualTo(2);
    }

    @DisplayName("해당 참여자가 몇번째 순서인지 반환한다.")
    @Test
    void getOrder() {
        final Players players = Players.from(List.of("bito", "kirby", "zeze", "ready"));

        Assertions.assertThat(players.getOrder(new Player("kirby"))).isEqualTo(1);
    }
}
