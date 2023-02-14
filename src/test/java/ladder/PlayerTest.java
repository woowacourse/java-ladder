package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 참여자는_이름을_가질_수_있다() {
        Player player = new Player("이름");
        assertThat(player.getName()).isEqualTo("이름");
    }

    @Test
    void 참여자의_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> {
            new Player("5글자넘어가는이름");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
