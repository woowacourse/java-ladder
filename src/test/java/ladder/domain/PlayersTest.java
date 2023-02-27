package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("플레이어가 1명 이하면 예외 던지기")
    public void size_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 수는 2 이상이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어 이름이 중복될 경우 예외던지기")
    public void 이름_중복_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("홍고", "홍고")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("플레이어수를 반환한다")
    public void getPlayerSize() {
        assertThat(Players.from(List.of("에밀", "홍고")).size()).isEqualTo(2);
    }


}
