package ladder.domain;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayerTest {

    @Test
    void 플레이어_생성_테스트() {
        assertThatCode(() -> Player.of("pobi", 0))
                .doesNotThrowAnyException();
    }

    @Test
    void 플레이어_왼쪽으로_이동_테스트() {
        Player player = Player.of("pobi", 3);
        player.moveLeft();

        assertThat(player.getPosition().getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어_오른쪽으로_이동_테스트() {
        Player player = Player.of("pobi", 3);
        player.moveRight();

        assertThat(player.getPosition().getPosition()).isEqualTo(4);
    }
}
