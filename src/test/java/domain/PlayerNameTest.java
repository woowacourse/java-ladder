package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {
    @ParameterizedTest
    @DisplayName("이름이 5자 이하고 공백이 아닌 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"무", "12345", "루 쿠  "})
    void create_player_Name(String name) {
        assertDoesNotThrow(() -> new PlayerName(name));
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다.")
    void name_6() {
        assertThatThrownBy(() -> new PlayerName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 5자를 넘길 수 없습니다.");
    }

    @DisplayName("이름이 공백이면 에외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void name_blank(String blankName) {
        assertThatThrownBy(() -> new PlayerName(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열 입니다.");
    }

    @DisplayName("이름이 all인 경우 예외가 발생한다")
    @Test
    void name_reserved() {
        assertThatThrownBy(() -> new PlayerName("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("all은 불가능한 이름입니다.");
    }

}
