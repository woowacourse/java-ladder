package domain.players;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {

    @DisplayName("참여자 이름은 5글자를 초과할 수 없다.")
    @Test
    void playerNameNotMoreThan5() {
        assertThatThrownBy(() -> new PlayerName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 최대 5글자까지 가능합니다.");
    }

    @DisplayName("참여자 이름은 빈 문자열일 수 없다.")
    @Test
    void playerNameNotBlank() {
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 공백일 수 없습니다.");
    }

    @DisplayName("참여자 이름은 1글자 이상 5글자 이하이다.")
    @ValueSource(strings = {"a", "abcde"})
    @ParameterizedTest
    void generatePlayerName(String playerName) {
        assertThatNoException()
                .isThrownBy(() -> new Player(playerName));
    }

    @DisplayName("참여자 이름은 all일 수 없다.")
    @Test
    void playerNameAllIsForbidden() {
        assertThatThrownBy(() -> new Player("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 \"all\"일 수 없습니다.");
    }

}
