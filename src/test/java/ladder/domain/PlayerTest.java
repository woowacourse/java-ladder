package ladder.domain;

import ladder.exception.PlayerNameLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThatCode;

class PlayerTest {

    @Test
    void 플레이어_생성_테스트() {
        assertThatCode(() -> new Player("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 플레이어_이름이_5자를_넘으면_예외_발생() {
        assertThatCode(() -> new Player("pobipo"))
                .isInstanceOf(PlayerNameLengthException.class);
    }

    @Test
    void 플레이어_이름이_1자_미만이면_예외_발생() {
        assertThatCode(() -> new Player(""))
                .isInstanceOf(PlayerNameLengthException.class);
    }
}