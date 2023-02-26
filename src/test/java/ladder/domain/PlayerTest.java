package ladder.domain;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayerTest {

    @Test
    void 플레이어_생성_테스트() {
        assertThatCode(() -> Player.of("pobi", 0))
                .doesNotThrowAnyException();
    }
}
