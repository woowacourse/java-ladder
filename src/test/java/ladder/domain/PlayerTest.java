package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {

    @Test
    void 참여자는_이름을_가질_수_있다() {
        Player player = new Player("이름", 0);
        assertThat(player.getName()).isEqualTo("이름");
    }

    @Nested
    class move_메소드는_방향에_따라_위치가_변한다 {
        @Test
        void LEFT인_경우_1_감소() {
            Player player = new Player("이름", 0);

            player.move(Direction.LEFT);

            assertThat(player.getPosition()).isEqualTo(-1);
        }

        @Test
        void RIGHT인_경우_1_증가() {
            Player player = new Player("이름", 0);

            player.move(Direction.RIGHT);

            assertThat(player.getPosition()).isEqualTo(1);
        }

        @Test
        void STRAIGHT인_경우_유지() {
            Player player = new Player("이름", 0);

            player.move(Direction.STRAIGHT);

            assertThat(player.getPosition()).isEqualTo(0);
        }
    }

}
