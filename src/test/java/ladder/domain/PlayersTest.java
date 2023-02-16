package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("플레이어가 1명 이하면 예외 던지기")
    public void size_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어수를 반환한다")
    public void getPlayerSize() {
        assertThat(Players.from(List.of("에밀", "홍고")).getPlayersSize()).isEqualTo(2);
    }
}