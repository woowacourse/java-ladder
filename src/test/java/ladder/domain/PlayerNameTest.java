package ladder.domain;

import ladder.domain.player.PlayerName;
import ladder.domain.player.exception.PlayerNameLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @Test
    void 플레이어_생성_테스트() {
        assertThatCode(() -> new PlayerName("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 플레이어_이름이_5자를_넘으면_예외_발생() {
        assertThatThrownBy(() -> new PlayerName("pobipo"))
                .isInstanceOf(PlayerNameLengthException.class);
    }

    @Test
    void 플레이어_이름이_1자_미만이면_예외_발생() {
        assertThatThrownBy(() -> new PlayerName(""))
                .isInstanceOf(PlayerNameLengthException.class);
    }
}