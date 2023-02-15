package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 참여자는_이름을_가질_수_있다() {
        Player player = new Player("이름");
        assertThat(player.getName()).isEqualTo("이름");
    }
}
