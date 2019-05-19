package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("ike", 1);
    }

    @Test
    void position_변경() {
        Player player1 = new Player("ike", 0);
        player1.updatePosition(1);
        assertThat(player1).isEqualTo(player);
    }
}