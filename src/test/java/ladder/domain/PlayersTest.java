package ladder.domain;

import ladder.domain.player.Players;
import ladder.exception.PlayerNumberException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayersTest {

    @Test
    void Players_생성_테스트() {
        assertThatCode(() -> new Players(List.of("pobi", "crong")))
                .doesNotThrowAnyException();
    }

    @Test
    void 총_플레이어는_두명_이상이_아니면_예외_발생() {
        assertThatThrownBy(() -> new Players(List.of("pobi")))
                .isInstanceOf(PlayerNumberException.class);
    }
}