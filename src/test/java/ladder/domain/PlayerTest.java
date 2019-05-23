package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void MOVE_TEST() {
        Direction direction = new Direction(false,true);
        Player player = new Player("test1",1);
        player.move(5,direction);
        assertThat(player.getPosition()).isEqualTo(2);
    }
}