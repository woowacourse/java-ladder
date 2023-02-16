package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"gray", "encho", "pobi", "ann"})
    @DisplayName("이름의 길이가 1~5인 경우, Player 객체가 생성된다.")
    void validateNameLength_Success(String name) {
        Player player = new Player(name);

        assertThat(player.getName()).isEqualTo(name);
    }


}
