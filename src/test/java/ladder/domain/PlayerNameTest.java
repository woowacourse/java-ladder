package ladder.domain;

import ladder.common.CustomException;
import ladder.domain.player.PlayerName;
import ladder.domain.player.exception.PlayerNameLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 플레이어_이름이_all_이면_예외_발생() {
        assertThatThrownBy(() -> new PlayerName("all"))
                .isInstanceOf(CustomException.class);
    }

    @Test
    void 이름이_같으면_equals가_true() {
        PlayerName playerName1 = new PlayerName("hello");
        PlayerName playerName2 = new PlayerName("hello");

        assertThat(playerName1).isEqualTo(playerName2);
    }
}