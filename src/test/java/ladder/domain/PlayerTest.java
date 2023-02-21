package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {

    @Test
    void 참여자는_이름을_가질_수_있다() {
        Player player = new Player("이름");
        assertThat(player.getName()).isEqualTo("이름");
    }

    @Test
    void move_메소드는_참여자의_위치를_이동한다() {
        Player player = new Player("주노");

        player.move(false, true);

        assertThat(player.getPosition()).isEqualTo(1);
    }
}
