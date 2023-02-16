package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNamesTest {

    @Test
    @DisplayName("모든 게임 참여자들의 이름 생성")
    void createPlayerNamesSuccess() {
        List<String> playerNamesInput = List.of("pobi", "honux", "crong", "jk");

        assertDoesNotThrow(() -> PlayerNames.from(playerNamesInput));
    }

    @Test
    @DisplayName("모든 게임 참여자들의 이름은 중복될 수 없다")
    void createPlayerNamesFail() {
        List<String> playerNamesInput = List.of("pobi", "pooh", "pooh", "jk");

        assertThatThrownBy(() -> PlayerNames.from(playerNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복될 수 없습니다.");
    }

}
