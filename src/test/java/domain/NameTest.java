package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {
    @ParameterizedTest
    @DisplayName("이름이 5자 이하고 공백이 아닌 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"무", "12345", "루 쿠  "})
    void create_player_Name(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다.")
    void name_6() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("글자 길이는 5자를 넘길 수 없습니다.");
    }

    @DisplayName("이름이 공백이면 에외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void name_blank(String blankName) {
        assertThatThrownBy(() -> new Name(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열 입니다.");
    }

}
