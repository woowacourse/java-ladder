package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNamesTest {

    public static final String PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = "참여자 수는 2 ~ 20명만 가능합니다.";

    @Test
    @DisplayName("모든 게임 참여자들의 이름 생성")
    void createPlayerNamesSuccess() {
        List<String> playerNamesInput = List.of("pobi", "honux", "crong", "jk");

        assertDoesNotThrow(() -> PlayerNames.from(playerNamesInput));
    }

    @Test
    @DisplayName("모든 게임 참여자들의 이름은 중복될 수 없다")
    void createPlayerNamesFail() {
        List<String> playerNamesInput = List.of("pobi", "honux", "crong", "pobi");

        assertThatThrownBy(() -> PlayerNames.from(playerNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("한명만 참여 할 수 없다")
    void createPlayerNumberUnderNumberFail() {
        List<String> playerNamesInput = List.of("pobi");

        assertThatThrownBy(() -> PlayerNames.from(playerNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    @Test
    @DisplayName("20명 이상은 참여 할 수 없다")
    void createPlayerNumberOverNumberFail() {
        List<String> playerNamesInput = new ArrayList<>();
        for (int asciiNumber = 0; asciiNumber < 21; asciiNumber++) {
            playerNamesInput.add(String.valueOf(asciiNumber + 'a'));
        }

        assertThatThrownBy(() -> PlayerNames.from(playerNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

}
