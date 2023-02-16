package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    public void size_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void get_People_Size(){
        assertThat(Players.from(List.of("에밀", "홍고")).getPlayersSize()).isEqualTo(2);
    }
}