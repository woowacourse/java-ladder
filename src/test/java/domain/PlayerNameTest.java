package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("플레이어의 이름은 1자 이상, 5자 이하가 아니면 예외를 던진다. -> 실패 케이스")
    void name_constructor_validate(String input) {
        // when & then
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 최소 1자 이상, 5자 이하입니다.");
    }

    @Test
    @DisplayName("플레이어의 이름의 길이를 반환한다.")
    void returns_length_of_player_name() {
        // given
        String name = "tobi";
        PlayerName playerName = new PlayerName(name);

        // when & then
        assertThat(playerName.getLengthOfName()).isEqualTo(name.length());
    }
}
