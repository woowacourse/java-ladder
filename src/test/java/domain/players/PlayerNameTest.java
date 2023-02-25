package domain.players;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(() -> new PlayerName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 공백일 수 없습니다.");
    }

    @DisplayName("참여자 이름은 1글자 이상 5글자 이하이다.")
    @ValueSource(strings = {"a", "abcde"})
    @ParameterizedTest
    void generatePlayerName(String playerName) {
        assertThatNoException()
                .isThrownBy(() -> new PlayerName(playerName));
    }

    @DisplayName("참여자 이름은 all일 수 없다.")
    @Test
    void playerNameAllIsForbidden() {
        assertThatThrownBy(() -> new PlayerName("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 \"all\"일 수 없습니다.");
    }

    @DisplayName("자신의 이름인지 확인할 수 있다.")
    @CsvSource(value = {"a:true", "b:false"})
    void isMyName(String name, boolean isSame) {
        PlayerName playerName = new PlayerName("a");

        assertThat(playerName.isMyName(name)).isEqualTo(isSame);
    }

}
