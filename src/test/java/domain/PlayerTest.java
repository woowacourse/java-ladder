package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("Player의 getLengthOfName은 Player의 이름의 길이를 반환한다.")
    void returns_player_name() {
        // given
        String givenName = "123";
        Player player = new Player(givenName);

        // when
        int expectedLengthOfName = player.getLengthOfPlayerName();

        // then
        assertThat(expectedLengthOfName).isEqualTo(givenName.length());
    }
}
