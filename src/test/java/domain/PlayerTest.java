package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("Player의 getName은 Player의 이름을 반환한다.")
    void returns_player_name() {
        // given
        String givenName = "123";
        Player player = new Player(givenName);

        // when
        String expectedName = player.getName();

        // then
        assertThat(expectedName).isEqualTo(givenName);
    }
}
