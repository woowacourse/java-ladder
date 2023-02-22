package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Name name;
    private Player player;

    @BeforeEach
    void setup() {
        name = new Name("포비");
        player = new Player(name);
    }

    @Test
    @DisplayName("Player 객체 getName 테스트")
    void getNameTest() {
        assertThat(player.getName()).isEqualTo(name.getName());
    }

}
