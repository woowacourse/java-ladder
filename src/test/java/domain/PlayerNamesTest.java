package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNamesTest {

    public static final String PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = "참여자 수는 2 ~ 20명만 가능합니다.";

    @Test
    @DisplayName("모든 게임 참여자들의 이름 생성")
    void createPlayerNamesSuccess() {
        String playerNamesInput = "pobi,honux,crong,jk";
        String delimiter = ",";

        assertDoesNotThrow(() -> PlayerNames.of(playerNamesInput, delimiter));
    }

    @Test
    @DisplayName("모든 게임 참여자들의 이름은 중복될 수 없다")
    void createPlayerNamesFail() {
        String playerNamesInput = "pobi,honux,crong,pobi";
        String delimiter = ",";

        assertThatThrownBy(() -> PlayerNames.of(playerNamesInput, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복될 수 없습니다.");
    }

    @DisplayName("한명만 참여 할 수 없다")
    @Test
    void createPlayerNumberUnderNumberFail() {
        String playerNamesInput = "pobi";
        String delimiter = ",";

        assertThatThrownBy(() -> PlayerNames.of(playerNamesInput, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    @DisplayName("20명 이상은 참여 할 수 없다")
    @Test
    void createPlayerNumberOverNumberFail() {
        StringBuilder playerNamesInput = new StringBuilder();
        String delimiter = ",";
        char toCharacter = 'a';
        for (int asciiNumber = 0; asciiNumber < 21; asciiNumber++) {
            playerNamesInput.append(asciiNumber)
                    .append(toCharacter)
                    .append(delimiter);
        }
        playerNamesInput.append("21a");

        assertThatThrownBy(() -> PlayerNames.of(playerNamesInput.toString(), delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

}
