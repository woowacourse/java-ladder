package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("TargetPlayer이면 True 반환")
    void isTargetPlayer() {
        String name = "pobi";
        Player player = new Player(name);

        assertThat(player.isTargetPlayer(name)).isTrue();
    }

}
